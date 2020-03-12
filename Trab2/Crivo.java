import java.util.Scanner;

public class Crivo extends Thread {
    private int id, inicio, fim;
    private boolean[] primos;

    private Crivo(int id, int inicio, int fim, boolean[] primos) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.primos = primos;
    }

    public void run() {
        System.out.println("Thread " + id + " acionada! Inicio= " + inicio + " fim = " + fim);
        crivoEratostenes();
    }

    public void exibeVetor() {
        // System.out.println("\n Exibindo o vetor " + id + ": Inicio = " + inicio +
        // "fim = " + fim);
        for (int i = inicio; i <= fim; i++)
            if (primos[i]) {
                System.out.printf("%d ", i);

            }
    }

    public void crivoEratostenes() {
        // int fimAux = (int) Math.sqrt(fim);
        for (int i = 2; i <= fim; i++) {
            for (int j = i; j * i <= fim; j++) {
                primos[i * j] = false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int qtd, numThreads;
        System.out.println("Digite a quantidade de números:");
        qtd = teclado.nextInt();
        System.out.println("Digite a quantidade de Threads: (Deve ser multiplo da qtd)");

        numThreads = teclado.nextInt();
        // Startando
        boolean[] primos = new boolean[qtd + 2];
        for (int i = 2; i <= qtd +1; i++)
            primos[i] = true;

        int inicioaux = 2;
        int fimstart = (qtd / numThreads) + 1;
        int fimaux = fimstart;
        Crivo[] threads = new Crivo[qtd];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Crivo(i, inicioaux, fimaux, primos);
            inicioaux = fimaux + 1;
            fimaux += fimstart - 1;
        }

        for (int i = 0; i < numThreads; i++)
            threads[i].start();

        for (int i = 0; i < numThreads; i++)
            threads[i].join();

        System.out.println("\n Resultado final: ");

        for (int i = 0; i < numThreads; i++)
            threads[i].exibeVetor();

    }
}