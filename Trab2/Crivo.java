import java.util.Scanner;

public class Crivo extends Thread {
    private int qtd;
    private boolean[] primos;

    private Crivo(int qtd) {
        this.qtd = qtd;
    }

    public void montaVetor() {
        boolean[] primos = new boolean[qtd + 1];
        System.out.println("\n Montando vetor...");
        for (int i = 2; i <= qtd; i++)
            primos[i] = true;

        this.primos = primos;
    }

    public void exibeVetor() {
        System.out.println("\n Exibindo o vetor:");
        for (int i = 2; i <= qtd; i++)
            if (primos[i]) {
                System.out.printf("%d ", i);

            }
    }

    public void crivoEratostenes() {
        int fim = (int) Math.sqrt(qtd);
        for (int i = 2; i <= fim; i++) {
            for (int j = i; j * i <= qtd; j++)
                primos[i * j] = false;

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Crivo crivo;
        Scanner teclado = new Scanner(System.in);

        int qtd;
        System.out.println("Digite a quantidade de números:");
        qtd = teclado.nextInt();
        crivo = new Crivo(qtd);
        crivo.montaVetor();
        crivo.exibeVetor();
        crivo.crivoEratostenes();
        crivo.exibeVetor();

    }
}