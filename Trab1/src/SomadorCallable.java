package src;

import java.util.concurrent.Callable;

public class SomadorCallable implements Callable<Integer> {

    public int[] numeros;
    private int inicio;
    private int fim;

    public SomadorCallable(int[] numeros, int inicio, int fim) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Integer call() throws Exception {
        try {
            int soma = 0;
            for (int i = inicio; i < fim; i++) {
                soma += numeros[i];
            }
            return soma;
        } finally {
            System.out.println("Thread " + Thread.currentThread().getId() + " -> Executando callable de " + inicio + " até " + fim);
        }
    }
}