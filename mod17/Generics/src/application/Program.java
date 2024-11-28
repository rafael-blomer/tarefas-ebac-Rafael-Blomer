package application;

import entities.Carro;
import entities.Garagem;
import entities.Honda;
import entities.Nissan;
import entities.Toyota;

public class Program {
    public static void main(String[] args) {
        Garagem<Carro> garagem = new Garagem<>();

        Honda honda = new Honda();
        Toyota toyota = new Toyota();
        Nissan nissan = new Nissan();

        garagem.adicionarCarro(honda);
        garagem.adicionarCarro(toyota);
        garagem.adicionarCarro(nissan);

        System.out.println("Carros na garagem:");
        for (Carro carro : garagem.retornarTudo()) {
            System.out.println(carro);
        }

        garagem.excluirTudo();

        System.out.println("\nCarros na garagem após exclusão:");
        for (Carro carro : garagem.retornarTudo()) {
            System.out.println(carro);
        }
    }
}
