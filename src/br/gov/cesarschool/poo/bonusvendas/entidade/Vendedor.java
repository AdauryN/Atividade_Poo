package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDate;
import java.time.Period;

public class Vendedor {
    private String cpf;
    private String nomeCompleto;
    private String sexo;
    private LocalDate dataNascimento;
    private double renda;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;

    public Vendedor(String cpf, String nomeCompleto, String sexo, LocalDate dataNascimento, double renda, String logradouro, String numero, String complemento, String cep, String cidade) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    public Vendedor() {
    }


	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	 public int calcularIdade() {
	        LocalDate dataAtual = LocalDate.now();
	        Period periodo = Period.between(dataNascimento, dataAtual);
	        return periodo.getYears();
	    }

}
