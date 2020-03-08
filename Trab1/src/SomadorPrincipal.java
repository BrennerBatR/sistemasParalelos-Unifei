package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SomadorPrincipal {
    public static void main(String[] args) {
        System.out.println("Iniciando a geração do array...");
        int[] numeros = new int[1000];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.abs(r.nextInt()) % 100; // abs pega o valor absoluto

        }
        System.out.println("Geração do array finalizada!");

        ExecutorService e = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

    }

}
