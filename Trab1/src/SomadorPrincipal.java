package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SomadorPrincipal {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Iniciando a geração do ARRAY...");
        int[] numeros = new int[10000];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.abs(r.nextInt()) % 100; // abs pega o valor absoluto

        }
        System.out.println("Geração do array finalizada!");

        ExecutorService e = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();
        System.out.println("Iniciando a execução dos CALLABLES..");

        for (int i = 0; i < 100; i++) {
            Future<Integer> result = e.submit(new SomadorCallable(numeros, i * 100, (i + 1) * 100));
            futures.add(result);
        }
        System.out.println("Callables executados !");

        System.out.println("Iniciando a SOMA ...");
        int soma = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("Pegando a soma " + i * 100 + " a " + (i + 1) * 100);
            Future<Integer> result = futures.get(i);
            soma += result.get();
        }
        System.out.println("Resultado(soma)= " + soma);
        e.shutdown();

    }

}
