package br.com.rafaelblomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Pessoa> listHomens = new ArrayList<Pessoa>();
		List<Pessoa> listMulheres = new ArrayList<Pessoa>();
		Integer x = 0;

		System.out.println("Digite nome de pessoas e seu respectivo sexo separandos por '-' e se desejar adicionar mais pessoas, utilize a vírgula para separar:");
		String[] array = sc.nextLine().split(",");

		while (x < array.length) {
			String[] nomeSexo = array[x].split("-");
			Pessoa pessoa = new Pessoa(nomeSexo[0], nomeSexo[1]);
			if (pessoa.getSexo().equalsIgnoreCase("masculino"))
				listHomens.add(pessoa);
			else
				listMulheres.add(pessoa);
			x++;
		}

		System.out.println("\n***HOMENS***");
		System.out.println(listHomens);
		System.out.println("\n***MULHERES***");
		System.out.println(listMulheres);

		sc.close();
	}

}
