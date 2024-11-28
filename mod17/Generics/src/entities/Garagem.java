package entities;

import java.util.ArrayList;
import java.util.List;

public class Garagem<T extends Carro> {
    private final List<T> carros = new ArrayList<>();

    public void adicionarCarro(T carro) {
        if (carro != null && !carros.contains(carro)) {
            carros.add(carro);
        }
    }

    public List<T> retornarTudo() {
        return new ArrayList<>(carros); 
    }

    public void excluirTudo() {
        carros.clear();
    }
}
