package br.gov.cesarschool.poo.bonusvendas.entidade;

public class LancamentoBonusDebito extends LancamentoBonus {
	private TipoResgate tipoResgate;

   
    public LancamentoBonusDebito(long numero, double valor, TipoResgate tipoResgate) {
        super(numero, valor);
        this.tipoResgate = tipoResgate;
    }

  
    public TipoResgate getTipoResgate() {
        return tipoResgate;
    }
}
