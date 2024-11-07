package br.com.rafaelblomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();
        String nome = "";

        while (!nome.equalsIgnoreCase("encerrar")) {
            System.out.println("Digite seu nome(Se deseja encerrar a aplicação, digite 'encerrar'): ");
            nome = sc.next();
            if (nome.equalsIgnoreCase("encerrar"))
                break;

            System.out.println("Digite seu sexo(Masculino/Feminino): ");
            String sexo = sc.next();

            if (sexo.equalsIgnoreCase("masculino"))
                masculino.add(nome);
            else if (sexo.equalsIgnoreCase("feminino"))
                feminino.add(nome);
            else
                System.out.println("Digite um sexo válido(Masculino/Feminino).");
        }

        System.out.println("***** HOMENS *****");
        for(String itemMasculino : masculino)
            System.out.println(itemMasculino);
        System.out.println("***** MULHERES *****");
        for(String itemFeminino : feminino)
            System.out.println(itemFeminino);
    }
}