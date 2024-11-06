package br.com.rafaelblomer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> listString = new ArrayList<String>();
		
		System.out.println("Digite nome de pessoas separados por vírgula: ");
		String[] array = sc.nextLine().split(",");
		
		for (String i : array)
			listString.add(i);
		
		Collections.sort(listString);
		System.out.println(listString);

		sc.close();
	}

}
