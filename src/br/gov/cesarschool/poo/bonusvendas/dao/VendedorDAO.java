package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {

    private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);

    private String criarChave(String cpf) {
        return cpf;
    }

    public boolean incluir(Vendedor vendedor) {
        String chave = criarChave(vendedor.getCPF());
        if (cadastro.buscar(chave) != null) {
            return false;
        } else {
            cadastro.incluir(vendedor, chave);
            return true;
        }
    }

    public boolean alterar(Vendedor vendedor) {
        String chave = criarChave(vendedor.getCPF());
        if (cadastro.buscar(chave) == null) {
            return false;
        } else {
            cadastro.alterar(vendedor, chave);
            return true;
        }
    }

    public Vendedor buscar(String cpf) {
        String chave = criarChave(cpf);
        return (Vendedor) cadastro.buscar(chave);
    }

    public Vendedor[] buscarTodos() {
        Serializable[] registros = cadastro.buscarTodos(Vendedor.class);
        Vendedor[] vendedores = new Vendedor[registros.length];
        for (int i = 0; i < registros.length; i++) {
            vendedores[i] = (Vendedor) registros[i];
        }
        return vendedores;
    }
}
