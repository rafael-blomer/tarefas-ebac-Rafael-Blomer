package entities;

import annotation.Tabela;

@Tabela("Class Carro")
public class Carro {

	@Tabela("Field Carro")
	private String nome;

	@Tabela("Constructor Carro")
	public Carro() {
		
	}

	@Tabela("Method GET")
	public String getNome() {
		return nome;
	}

	@Tabela("Method SET")
	public void setNome(String nome) {
		this.nome = nome;
	}
}
