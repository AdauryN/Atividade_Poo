package br.gov.cesarschool.poo.bonusvendas.DAO;

import br.gov.cesarschool.poo.bonusvendas.model.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {
    private static List<Vendedor> vendedores = new ArrayList<>();

    public static void salvar(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public static List<Vendedor> getVendedores() {
        return vendedores;
    }
    
    public void inserir(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

}
