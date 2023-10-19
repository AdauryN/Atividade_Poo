package br.gov.cesarschool.poo.bonusvendas.mediator;

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

    public void cadastrarVendedor(
            String cpf, String nomeCompleto, Sexo sexo, LocalDate dataNascimento, 
            double renda, String logradouro, int numero, String complemento, 
            String cep, String cidade, String estado, String pais) {

        Endereco endereco = new Endereco(logradouro, numero, complemento, cep, cidade, estado, pais);
        Vendedor vendedor = new Vendedor(cpf, nomeCompleto, sexo, dataNascimento, renda, endereco);
        vendedorDAO.incluir(vendedor);
    }


}
