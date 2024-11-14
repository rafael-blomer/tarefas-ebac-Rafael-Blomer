package padrõesProjeto1;

import padrõesProjeto1.classes.Carro;
import padrõesProjeto1.classes.CarroCombustaoFactory;
import padrõesProjeto1.classes.CarroEletricoFactory;
import padrõesProjeto1.interfaces.CarroFactory;

public class Program {

	public static void main(String[] args) {

		CarroFactory eletrico = new CarroEletricoFactory();
		Carro carroEletrico = new Carro(eletrico);
		carroEletrico.iniciar();
		
		System.out.println("\n=====================\n");
		
		CarroFactory combustao = new CarroCombustaoFactory();
		Carro carroCombustao = new Carro(combustao);
		carroCombustao.iniciar();
		
	}

}
