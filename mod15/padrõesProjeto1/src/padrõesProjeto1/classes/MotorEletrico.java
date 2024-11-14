package padrõesProjeto1.classes;

import padrõesProjeto1.interfaces.Motor;

public class MotorEletrico implements Motor{

	@Override
	public void ligar() {
		System.out.println("Ligando motor elétrico.");
	}
}
