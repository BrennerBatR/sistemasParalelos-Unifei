import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

//Esse algoritimo usa Paralelismo de dados, nele eu divido o vetor pelo numero de threads e busco o maior local. Apos obter esse maior local eu verifico o maior global
public class Maior extends Thread {
    private int id, inicio, fim, maior;
    private int[] vetor;

    private Maior(int id, int inicio, int fim, int[] vetor) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.vetor = vetor;
    }

    public void exibeVetor() {
        for (int i = inicio; i <= fim; i++)
            System.out.printf("%d ", i);

    }

    public void calculaMaior() {
        // System.out.println("\n Calculando o maior do vetor " + id + ": Inicio = " +
        // inicio + "fim = " + fim);
        maior = vetor[inicio];
        for (int i = 1; i < fim; i++)
            if (maior < vetor[i])
                maior = vetor[i];

        // System.out.println("Maior " + id + "= " + maior);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int qtd, numThreads;

        System.out.println("Digite a quantidade de números:");
        qtd = teclado.nextInt();
        System.out.println("Digite a quantidade de Threads: (Deve ser multiplo da qtd)");
        numThreads = teclado.nextInt();
        long tempoInicio = System.currentTimeMillis();
        // Startando
        // System.out.println("Iniciando a geração do ARRAY de tamanho: " + qtd);
        int[] numeros = new int[qtd];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < qtd; i++) {
            numeros[i] = Math.abs(r.nextInt()) % 10000; // abs pega o valor absoluto
            // System.out.printf("%d ", numeros[i]);
        }

        // System.out.printf("\n");
        int[] vetor = numeros;

        int inicioaux = 0;
        int fimstart = (qtd / numThreads);
        int fimaux = fimstart;
        Maior[] threads = new Maior[qtd];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Maior(i, inicioaux, fimaux, vetor);
            inicioaux = fimaux + 1;
            fimaux += fimstart - 1;
        }

        for (int i = 0; i < numThreads; i++)
            threads[i].start();

        for (int i = 0; i < numThreads; i++)
            threads[i].join();

        // System.out.println("\n Resultado parcial: ");

        int resultado = 0;
        for (int i = 0; i < numThreads; i++) {
            threads[i].calculaMaior();
            if (resultado < threads[i].maior)
                resultado = threads[i].maior;
        }

        System.out.println("\n Resultado Final: " + resultado);
        long tempoFim = System.currentTimeMillis();
        System.out.println(
                "\n Tempo gasto: " + new SimpleDateFormat("mm:ss.SSS").format(new Date(tempoFim - tempoInicio)));

    }
}