package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;

public class AcumuloResgateMediator {

    private static AcumuloResgateMediator instance;
    private LancamentoBonusDAO lancamentoBonusDAO;
    private static long ultimoNumeroCaixaDeBonus = 0;

    private AcumuloResgateMediator() {
        lancamentoBonusDAO = new LancamentoBonusDAO();
    }

    public static AcumuloResgateMediator getInstance() {
        if (instance == null) {
            instance = new AcumuloResgateMediator();
        }
        return instance;
    }

    public long gerarCaixaDeBonus(Vendedor vendedor) {
        ultimoNumeroCaixaDeBonus++;
        return ultimoNumeroCaixaDeBonus;
    }

    public String acumularBonus(long numeroCaixaDeBonus, double valor) {
        if (valor <= 0) {
            return "Valor menor ou igual a zero";
        }
        LancamentoBonus lancamento = new LancamentoBonus(numeroCaixaDeBonus, valor);
        lancamentoBonusDAO.incluir(lancamento);
        return "Acumulado com sucesso: " + valor;
    }


    public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo) {
        LancamentoBonus lancamento;
        String mensagem;
        switch (tipo) {
            case PRODUTO:
                lancamento = new LancamentoBonus(numeroCaixaDeBonus, -valor / 2);
                mensagem = "Resgate de produto efetuado.";
                break;
            case SERVICO:
                lancamento = new LancamentoBonus(numeroCaixaDeBonus, -valor / 3);
                mensagem = "Resgate de serviço efetuado.";
                break;
            case CASH:
                lancamento = new LancamentoBonus(numeroCaixaDeBonus, -valor);
                mensagem = "Resgate em dinheiro efetuado.";
                break;
            default:
                lancamento = new LancamentoBonus(numeroCaixaDeBonus, 0);
                mensagem = "Tipo de resgate inválido.";
                break;
        }
        lancamentoBonusDAO.incluir(lancamento);
        return mensagem;
    }





    public double buscarSaldo(long numeroCaixaDeBonus) {
        LancamentoBonus[] lancamentos = lancamentoBonusDAO.buscarTodos();
        double saldo = 0.0;
        for (LancamentoBonus lancamento : lancamentos) {
            if (lancamento.getNumeroCaixaDeBonus() == numeroCaixaDeBonus) {
                saldo += lancamento.getValor();
            }
        }
        return saldo;
    }
}

