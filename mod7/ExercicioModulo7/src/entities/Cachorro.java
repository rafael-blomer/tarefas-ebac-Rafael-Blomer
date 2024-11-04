package entities;

/**
 * @author Rafael Ceccatto Blomer
 * Classe de Cachorro
 * **/
public class Cachorro {

	private String raca;
	private String nome;
	private int idade;
	
	public Cachorro() {
		
	}
	
	public Cachorro(String raca, String nome, int idade) {
		this.raca = raca;
		this.nome = nome;
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	/**
	 * @return Retorna o cachorro e sua idade
	 * Faz o cachorro fazer aniversário
	 * **/
	public String fazerAniversario() {
		idade += 1;
		return "O " + nome + " fez " + idade + " anos, Parabéns!";
	}
	
	/**
	 * @return Retorna o cachorro latindo
	 * Faz o cachorro latir
	 * **/
	public String latir() {
		return "AU! AU! AU!";
	}
	
	/**
	 * @return Retorna o cachorro dormindo
	 * Faz o cachorro dormir
	 * **/
	public String dormir() {
		return "O " + nome + " dormiu." + "\nZzZZzzzzZZzZ";
	}
	
	/**
	 * @return Retorna as informações do cachorro
	 * Tem as informações do cachorro
	 * **/
	public String informacoes() {
		return nome + " é um cachorro da raça " + raca + " e tem " + idade + " anos!";
	}
	
	/**
	 * Da um brinquedo para o cachorro
	 * @return Retorna a informaçao do brinquedo e o nome do cachorro
	 * @param Passa um nome de brinquedo como parâmetro
	 * **/
	public String darBriquedo(String briquedo) {
		return "Você deu uma " + briquedo + " para o " + nome + "\nEle está muito feliz."; 
	}
}
