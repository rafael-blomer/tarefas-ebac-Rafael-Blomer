package padrõesProjeto1.classes;

import padrõesProjeto1.interfaces.Energia;

public class TanqueCombustivel implements Energia {

	@Override
	public void fornecerEnergia() {
		System.out.println("Enchendo tanque de gasolina.");
	}

}
