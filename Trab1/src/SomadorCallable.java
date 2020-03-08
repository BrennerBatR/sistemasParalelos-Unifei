package src;

import java.util.concurrent.Callable;

public class SomadorCallable implements Callable<Integer> {

    public int[] numeros;
    private int inicio;
    private int fim;

    public void SomamdorCallable(int[] numeros, int inicio, int fim) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Integer call() throws Exception {
        int soma = 0;
        for (int i = inicio; i < fim; i++) {
            soma += numeros[i];
        }
        return soma;
    }
}