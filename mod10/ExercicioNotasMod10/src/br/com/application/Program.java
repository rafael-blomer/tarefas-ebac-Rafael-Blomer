package br.com.application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double notaTotal = 0.0;
        int i = 1;
        
        System.out.println("*****Programa iniciado*****");
        while (i < 5) {
            System.out.println("Digite sua " + i + "ª nota.");
            notaTotal += sc.nextDouble();
            i++;
        }

        Double media = notaTotal / 4;

        if (media < 5)
            System.out.println("Nota: " + media + "\nSituação: Reprovado.");
        else if (media >= 7)
            System.out.println("Nota: " + media + "\nSituação: Aprovado.");
        else if (media >= 5)
            System.out.println("Nota: " + media + "\nSituação: Recuperação.");
        
        sc.close();
    }
}