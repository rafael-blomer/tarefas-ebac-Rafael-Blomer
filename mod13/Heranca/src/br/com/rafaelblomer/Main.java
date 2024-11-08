package br.com.rafaelblomer;

import br.com.rafaelblomer.entities.PessoaFisica;
import br.com.rafaelblomer.entities.PessoaJuridica;

public class Main {
    public static void main(String[] args) {
        PessoaJuridica pj = new PessoaJuridica("Loja 1", "Rua 20", "00.000.000/0000-00");
        PessoaFisica pf = new PessoaFisica("Rafael", "Rua 10", "000.000.000-00");

        System.out.println(pj);
        System.out.println(pf);
    }
}