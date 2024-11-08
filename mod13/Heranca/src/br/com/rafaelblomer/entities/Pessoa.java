package br.com.rafaelblomer.entities;

public abstract class Pessoa {
    private String nome;
    private String endereco;

    public Pessoa() {

    }

    public Pessoa(String nome, String endereco) {
        this.endereco = endereco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
