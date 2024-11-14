package padrõesProjeto1.classes;

import padrõesProjeto1.interfaces.Motor;

public class MotorCombustao implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando motor a combustão.");
	}

}
