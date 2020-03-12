import java.util.Scanner;

public class Crivo extends Thread {
    private int id, inicio, fim;
    private boolean[] primos;

    private boolean[] getPrimos() {
        return primos;
    }

    private Crivo(int id, int inicio, int fim) {
        this.id = id;

        this.inicio = inicio;
        this.fim = fim;
    }

    public void run() {
      //  System.out.println("id = " + id + " inicio = " + inicio + " fim = " + fim);
        montaVetor();
        crivoEratostenes();
    }

    public void montaVetor() {
        boolean[] primos = new boolean[fim + 1];
        for (int i = inicio; i <= fim; i++)
            primos[i] = true;

        this.primos = primos;
    }

    public void exibeVetor() {
        //System.out.println("\n Exibindo o vetor " + id + ": Inicio = " + inicio + "fim = " + fim);
        for (int i = inicio; i <= fim; i++)
            if (primos[i]) {
                System.out.printf("%d ", i);

            }
    }

    public void crivoEratostenes() {
        // int fimAux = (int) Math.sqrt(fim);
        for (int i = inicio; i <= fim; i++) {
            for (int j = i; j * i <= fim; j++) {
                primos[i * j] = false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Crivo t1, t2;
        Scanner teclado = new Scanner(System.in);

        int qtd, parcial;
        System.out.println("Digite a quantidade de números:");
        qtd = teclado.nextInt();

        parcial = (qtd + 2) / 2;

        t1 = new Crivo(1, 2, parcial);
        t2 = new Crivo(2, parcial + 1, qtd);

        t1.start();
        t2.start();

        t1.join(); // join serve para a thread principal ficar bloqueada ate a thread 1 retornar
        t2.join();

        System.out.println("\n Resultado final: ");
        t1.exibeVetor();
        t2.exibeVetor();

    }
}