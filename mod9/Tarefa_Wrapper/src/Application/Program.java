package Application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um número inteiro:");
		int inteiroPrimitivo = sc.nextInt();
		Integer inteiroWrapper = Integer.valueOf(inteiroPrimitivo);
		System.out.println("Valor primitivo:" + inteiroPrimitivo);
		System.out.println("Valor Wrapper:" + inteiroWrapper);
		
		System.out.println("\nDigite um número com ponto flutuante");
		double doublePrimitivo = sc.nextDouble();
		Double doubleWrapper = Double.valueOf(doublePrimitivo);
		System.out.println("Valor primitivo:" + doublePrimitivo);
		System.out.println("Valor Wrapper:" + doubleWrapper);

		sc.close();
	}

}
