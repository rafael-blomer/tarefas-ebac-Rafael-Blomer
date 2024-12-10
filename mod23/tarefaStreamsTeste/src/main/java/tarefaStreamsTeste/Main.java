package tarefaStreamsTeste;

import java.util.List;
import java.util.Scanner;

import tarefaStreamsTeste.entities.Pessoa;

public class Main {
	private static final Pessoa p1 = new Pessoa();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome e o sexo de pessoas separando o nome e o sexo por '-' e as pessoas por ','.");
		System.out.println("Ex: João-masculino,Maria-feminino,...");
		// João-masculino,Maria-feminino,Rafael-masculino,Gabriela-feminino,Luísa-feminino
		String resposta = sc.nextLine();

		List<Pessoa> mulheres = p1.separarMulheres(resposta);

		mulheres.forEach(System.out::println);
		sc.close();
	}
}