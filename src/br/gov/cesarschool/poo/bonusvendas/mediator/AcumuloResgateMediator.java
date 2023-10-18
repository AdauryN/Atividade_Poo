package br.gov.cesarschool.poo.bonusvendas.mediator;

import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class AcumuloResgateMediator {

    private static AcumuloResgateMediator instance;
    private LancamentoBonusDAO lancamentoBonusDAO;

    private AcumuloResgateMediator() {
        lancamentoBonusDAO = new LancamentoBonusDAO();
    }

    public static AcumuloResgateMediator getInstance() {
        if (instance == null) {
            instance = new AcumuloResgateMediator();
        }
        return instance;
    }

    public void acumular(long numeroCaixaDeBonus, double valor) {
        LancamentoBonus lancamento = new LancamentoBonus(numeroCaixaDeBonus, valor);
        lancamentoBonusDAO.incluir(lancamento);
    }

    public void resgatar(long numeroCaixaDeBonus, double valor) {
        LancamentoBonus lancamento = new LancamentoBonus(numeroCaixaDeBonus, -valor);
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
