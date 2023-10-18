package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonus {
	private long numeroCaixaDeBonus;
	private double valor;
	private LocalDateTime dataHoraLancamento;
	
	public LancamentoBonus(long numeroCaixaDeBonus, double valor) {
        this.setNumeroCaixaDeBonus(numeroCaixaDeBonus);
        this.setValor(valor);
        this.setDataHoraLancamento(LocalDateTime.now()); 
    }

	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public void setNumeroCaixaDeBonus(long numeroCaixaDeBonus) {
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}

	public void setDataHoraLancamento(LocalDateTime dataHoraLancamento) {
		this.dataHoraLancamento = dataHoraLancamento;
	}
}
