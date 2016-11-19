package br.com.fiap.olimpiadasdialog;

/**
 * Created by rm31661 on 17/10/2016.
 */
public class Ingresso {

    private String nome;
    private int idade;
    private String modalidade;
    private String periodo;

    @Override
    public String toString() {
        return "Ingresso{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", modalidade='" + modalidade + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }

    public Ingresso(){}

    public Ingresso(String nome, int idade, String modalidade, String periodo) {
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
