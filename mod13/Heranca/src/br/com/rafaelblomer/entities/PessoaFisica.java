package br.com.rafaelblomer.entities;

public class PessoaFisica extends Pessoa{
    private String cpf;

    public PessoaFisica() {

    }

    public PessoaFisica(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() +
                "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}