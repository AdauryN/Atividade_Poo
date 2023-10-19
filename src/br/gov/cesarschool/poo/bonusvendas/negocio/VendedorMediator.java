package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

import java.time.LocalDate;

public class VendedorMediator {

    private static VendedorMediator instance;
    private VendedorDAO vendedorDAO;

    private VendedorMediator() {
        vendedorDAO = new VendedorDAO(); 
    }

    public static VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }

    public ResultadoInclusaoVendedor cadastrarVendedor(
            String cpf, String nomeCompleto, Sexo sexo, LocalDate dataNascimento, 
            double renda, String logradouro, int numero, String complemento, 
            String cep, String cidade, String estado, String pais) {

        ResultadoInclusaoVendedor resultado;
        try {
            Endereco endereco = new Endereco(logradouro, numero, complemento, cep, cidade, estado, pais);
            Vendedor vendedor = new Vendedor(cpf, nomeCompleto, sexo, dataNascimento, renda, endereco);
            vendedorDAO.incluir(vendedor);
            resultado = new ResultadoInclusaoVendedor(true, "Vendedor cadastrado com sucesso.");
        } catch (Exception e) {
            resultado = new ResultadoInclusaoVendedor(false, "Falha ao cadastrar vendedor: " + e.getMessage());
        }

        return resultado;
    }
    
    public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
        ResultadoInclusaoVendedor resultado;
        try {
            vendedorDAO.incluir(vendedor);
            resultado = new ResultadoInclusaoVendedor(true, "Vendedor incluído com sucesso.");
        } catch (Exception e) {
            resultado = new ResultadoInclusaoVendedor(false, "Falha ao incluir vendedor: " + e.getMessage());
        }
        return resultado;
    }

    public String alterar(Vendedor vendedor) {
        try {
            vendedorDAO.alterar(vendedor);
            return "Vendedor alterado com sucesso.";
        } catch (Exception e) {
            return "Falha ao alterar vendedor: " + e.getMessage();
        }
    }




}
