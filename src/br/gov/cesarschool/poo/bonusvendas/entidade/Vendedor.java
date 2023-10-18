package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;

public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nomeCompleto;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private double renda;
    private Endereco endereco;

    public Vendedor(String cpf, String nomeCompleto, Sexo sexo, LocalDate dataNascimento, double renda, Endereco endereco) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.endereco = endereco;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
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

    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
