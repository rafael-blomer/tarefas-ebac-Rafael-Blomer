package padrõesProjeto1.classes;

import padrõesProjeto1.interfaces.Energia;

public class Bateria implements Energia {

	@Override
	public void fornecerEnergia() {
		System.out.println("Fornecendo energia para bateria.");
	}

}
