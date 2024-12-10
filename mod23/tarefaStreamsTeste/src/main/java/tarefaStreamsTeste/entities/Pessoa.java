package tarefaStreamsTeste.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pessoa {
	private String nome;
	private String sexo;

	public Pessoa() {

	}

	public Pessoa(String nome, String sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pessoa pessoa = (Pessoa) o;
		return Objects.equals(nome, pessoa.nome) && Objects.equals(sexo, pessoa.sexo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sexo);
	}

	@Override
	public String toString() {
		return "Pessoa{" + "nome='" + nome + '\'' + ", sexo='" + sexo + '\'' + '}';
	}

	public List<Pessoa> separarMulheres(String resposta) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		String[] separarPessoas = resposta.split(",");
		for (String a : separarPessoas) {
			String[] separarNomeSexo = a.split("-");
			pessoas.add(new Pessoa(separarNomeSexo[0], separarNomeSexo[1]));
		}

		return pessoas.stream().filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("feminino"))
				.collect(Collectors.toList());
	}
}