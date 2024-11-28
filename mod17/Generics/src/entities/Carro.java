package entities;

public abstract class Carro {
	
	private String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
    	this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + " (Classe: " + getClass().getSimpleName() + ")";
    }
}
