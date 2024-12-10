package tarefaStreamsTeste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import tarefaStreamsTeste.entities.Pessoa;

public class TesteMulheres {

	@Test
	public void testVerificaSexo() {
		final Pessoa pessoa = new Pessoa();
		
		List<Pessoa> mulheres = pessoa.separarMulheres("João-masculino,Maria-feminino,Rafael-masculino,Gabriela-feminino,Luísa-feminino");
		for (Pessoa p : mulheres) {
			assertEquals(p.getSexo(), "feminino");
		}
	}
}
