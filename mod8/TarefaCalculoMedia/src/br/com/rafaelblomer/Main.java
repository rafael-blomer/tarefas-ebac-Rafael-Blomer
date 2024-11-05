package br.com.rafaelblomer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double notaTotal = 0.0;

        System.out.println("*****Programa iniciado*****");
        for (int i = 0; i < 4; i++) {
            System.out.println("Digite sua " + (i + 1) + "ª nota.");
            notaTotal += sc.nextDouble();
        }

        Double media = notaTotal / 4;

        if (media <= 5)
            System.out.println("Nota: " + media + "\nSituação: Reprovado.");
        else if (media < 7)
            System.out.println("Nota: " + media + "\nSituação: Recuperação.");
        else if (media >= 7)
            System.out.println("Nota: " + media + "\nSituação: Aprovado.");
    }
}