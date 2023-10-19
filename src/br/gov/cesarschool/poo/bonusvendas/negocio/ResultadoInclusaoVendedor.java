package br.gov.cesarschool.poo.bonusvendas.negocio;

public class ResultadoInclusaoVendedor {
    private boolean sucesso;
    private String mensagem;
    private String mensagemErroValidacao;
    private int numeroCaixaDeBonus;

    public ResultadoInclusaoVendedor(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
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
