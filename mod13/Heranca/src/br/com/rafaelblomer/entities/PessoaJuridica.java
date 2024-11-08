package br.com.rafaelblomer.entities;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica() {

    }

    public PessoaJuridica(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() +
                "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
