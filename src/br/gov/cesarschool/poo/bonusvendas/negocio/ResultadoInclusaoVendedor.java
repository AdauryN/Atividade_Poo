package br.gov.cesarschool.poo.bonusvendas.negocio;

public class ResultadoInclusaoVendedor {
    private boolean sucesso;
    private String mensagem;
    private String mensagemErroValidacao;
    private int numeroCaixaDeBonus;
    private long numeroCaixaDeBonusl;

    public ResultadoInclusaoVendedor(int numeroCaixaDeBonus, String mensagemErroValidacao) {
        this.numeroCaixaDeBonus = numeroCaixaDeBonus;
        this.mensagemErroValidacao = mensagemErroValidacao;
        this.sucesso = (mensagemErroValidacao == null);
    }
    
    public ResultadoInclusaoVendedor(long numeroCaixaDeBonusl, String mensagemErroValidacao) {
        this.numeroCaixaDeBonusl = numeroCaixaDeBonusl;
        this.mensagemErroValidacao = mensagemErroValidacao;
        this.sucesso = (mensagemErroValidacao == null);
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagemErroValidacao() {
        return mensagemErroValidacao;
    }

    public void setMensagemErroValidacao(String mensagemErroValidacao) {
        this.mensagemErroValidacao = mensagemErroValidacao;
    }

    public int getNumeroCaixaDeBonus() {
        return numeroCaixaDeBonus;
    }

    public void setNumeroCaixaDeBonus(int numeroCaixaDeBonus) {
        this.numeroCaixaDeBonus = numeroCaixaDeBonus;
    }
}
