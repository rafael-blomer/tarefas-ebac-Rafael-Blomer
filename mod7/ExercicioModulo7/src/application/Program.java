package application;

import entities.Cachorro;

/**
 * @author Rafael Ceccatto Blomer
 * Programa principal
 * **/
public class Program {

	public static void main(String[] args) {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome("Theo");
		cachorro.setRaca("Bulldog");
		cachorro.setIdade(4);
		System.out.println(cachorro.informacoes());
		System.out.println(cachorro.dormir());
		System.out.println(cachorro.getNome());
		System.out.println(cachorro.latir());
		System.out.println(cachorro.fazerAniversario());
		System.out.println(cachorro.informacoes());
		System.out.println(cachorro.darBriquedo("Bola"));		
	}

}
