package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;


public class CaixaDeBonus {
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao;
	
	public CaixaDeBonus(long numero) {
        this.numero = numero;
        this.saldo = 0.0; 
        this.dataHoraAtualizacao = LocalDateTime.now(); 
    }


	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }
	
	void creditar(double valor){
		this.saldo += valor;
        this.dataHoraAtualizacao = LocalDateTime.now();
		
	}
	void debitar(double valor){
		 if (valor <= this.saldo) {
	            this.saldo -= valor;
	            this.dataHoraAtualizacao = LocalDateTime.now();
	        } else {
	        	 System.out.println("Saldo insuficiente para debitar " + valor);
	        }
	}
}