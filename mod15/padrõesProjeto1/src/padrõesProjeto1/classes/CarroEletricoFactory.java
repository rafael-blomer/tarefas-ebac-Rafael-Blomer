package padrõesProjeto1.classes;

import padrõesProjeto1.interfaces.CarroFactory;
import padrõesProjeto1.interfaces.Energia;
import padrõesProjeto1.interfaces.Motor;

public class CarroEletricoFactory implements CarroFactory{

	@Override
	public Motor criarMotor() {
		return new MotorEletrico();
	}

	@Override
	public Energia criarEnergia() {
		return new Bateria();
	}

}
