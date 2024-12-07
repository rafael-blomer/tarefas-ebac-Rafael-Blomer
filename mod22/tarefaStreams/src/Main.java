import entities.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite o nome e o sexo de pessoas separando o nome e o sexo por '-' e as pessoas por ','.");
        System.out.println("Ex: João-masculino,Maria-feminino,...");
        //João-masculino,Maria-feminino,Rafael-masculino,Gabriela-feminino,Luísa-feminino
        String resposta = sc.nextLine();
        String[] separarPessoas = resposta.split(",");
        for (String a : separarPessoas) {
            String[] separarNomeSexo = a.split("-");
            pessoas.add(new Pessoa(separarNomeSexo[0],  separarNomeSexo[1]));
        }

        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("feminino"))
                .collect(Collectors.toList());

        mulheres.forEach(System.out::println);
    }
}