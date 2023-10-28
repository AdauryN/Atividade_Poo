package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.*;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import java.util.Calendar;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;


public class VendedorMediator {

    private static VendedorMediator instance;
    private VendedorDAO repositorioVendedor;
    private AcumuloResgateMediator caixaDeBonusMediator;

    private VendedorMediator() {
        repositorioVendedor = new VendedorDAO();
        caixaDeBonusMediator = AcumuloResgateMediator.getInstance();
    }

    public static synchronized VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }

    public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
        String mensagemErroValidacao = validar(vendedor);
        if (mensagemErroValidacao != null) {
            return new ResultadoInclusaoVendedor(0, mensagemErroValidacao);
        }
        repositorioVendedor.incluir(vendedor);
        long numeroCaixaDeBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
        return new ResultadoInclusaoVendedor(numeroCaixaDeBonus, null);
    }

    public String alterar(Vendedor vendedor) {
        String mensagemErroValidacao = validar(vendedor);
        if (mensagemErroValidacao != null) {
            return mensagemErroValidacao;
        }
        
        Vendedor vendedorExistente = repositorioVendedor.buscar(vendedor.getCPF());
        if (vendedorExistente == null) {
            return "Vendedor inexistente";
        }
        
        repositorioVendedor.alterar(vendedor);
        return null;
    }


    private String validar(Vendedor vendedor) {
        if (vendedor == null) {
            return "Vendedor nao informado";
        }

        if (!ValidadorCPF.ehCpfValido(vendedor.getCPF())) {
            return "CPF invalido";
        }

        if (StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
            return "Nome completo nao informado";
        }

        if (vendedor.getSexo() == null) {
            return "Sexo nao informado";
        }

        if (vendedor.getDataNascimento() == null) {
            return "Data de nascimento nao informada";
        }

        LocalDate hoje = LocalDate.now();
        LocalDate nascimento = vendedor.getDataNascimento();
        int idade = Period.between(nascimento, hoje).getYears();

        if (idade < 18) {
            return "Data de nascimento invalida";
        }

        if (vendedor.getRenda() < 0) {
            return "Renda menor que zero";
        }

        Endereco endereco = vendedor.getEndereco();
        if (endereco == null) {
            return "Endereco nao informado";
        }

        if (StringUtil.ehNuloOuBranco(endereco.getLogradouro()) || endereco.getLogradouro().length() < 4) {
            return "Logradouro nao informado ou tem menos de 04 caracteres";
        }

        if (endereco.getNumero() < 0) {
            return "Numero menor que zero";
        }

        if (StringUtil.ehNuloOuBranco(endereco.getCidade())) {
            return "Cidade nao informada";
        }

        if (StringUtil.ehNuloOuBranco(endereco.getEstado())) {
            return "Estado nao informado";
        }

        if (StringUtil.ehNuloOuBranco(endereco.getPais())) {
            return "Pais nao informado";
        }

        return null;
    }

    public Vendedor buscar(String cpf) {
        return repositorioVendedor.buscar(cpf);
    }
}
