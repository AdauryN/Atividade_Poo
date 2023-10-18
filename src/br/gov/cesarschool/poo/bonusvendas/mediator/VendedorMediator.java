package br.gov.cesarschool.poo.bonusvendas.mediator;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.model.Vendedor;

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

    public void cadastrarVendedor(String cpf, String nomeCompleto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setCPF(cpf);
        vendedor.setNomeCompleto(nomeCompleto);
        vendedorDAO.inserir(vendedor);
    }

}
