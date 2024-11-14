package padrõesProjeto1.classes;

import padrõesProjeto1.interfaces.CarroFactory;
import padrõesProjeto1.interfaces.Energia;
import padrõesProjeto1.interfaces.Motor;

public class Carro {

	private Motor motor;
	private Energia energia;
	
	public Carro(CarroFactory factory) {
		this.motor = factory.criarMotor();
		this.energia = factory.criarEnergia();
	}
	
	public void iniciar() {
		motor.ligar();
		energia.fornecerEnergia();
	}
}
