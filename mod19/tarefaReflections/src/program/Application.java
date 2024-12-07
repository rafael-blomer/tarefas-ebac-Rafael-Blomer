package program;

import annotation.Tabela;
import entities.Carro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Application {

    public static void main(String args[]) throws NoSuchFieldException, NoSuchMethodException {
        Class<?> cl = Carro.class;
        Carro carro = new Carro();
        Constructor cr = cl.getConstructor();

        System.out.println(cl.getAnnotation(Tabela.class));
        System.out.println(carro.getClass().getDeclaredField("nome").getAnnotation(Tabela.class));
        System.out.println(cr.getAnnotation(Tabela.class));
        for (Method a : carro.getClass().getDeclaredMethods())
            System.out.println(a.getAnnotation(Tabela.class));
    }
}
