import java.util.Scanner;

public class Exemplo1 extends Thread {
    private int resultado = 0;
    private int id, inicio, fim;

    private Exemplo1(int id, int inicio, int fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void run() {
        soma(inicio, fim);
        System.out.println("Parcial da thread " + id + " = " + Resultado());
    }

    public int Resultado() {
        return resultado;
    }

    public void soma(int inicio, int fim) {
        resultado = 0;
        for (int i = inicio; i <= fim; i++)
            resultado += i;

    }

    public static void main(String[] args) throws InterruptedException {
        Exemplo1 t1, t2;

        int inicio, fim, passo;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o inicio:");
        inicio = teclado.nextInt();
        System.out.println("Digite o fim:");
        fim = teclado.nextInt();

        Exemplo1 obj = new Exemplo1(0, inicio, fim);

        obj.soma(inicio, fim);
        System.out.println("Soma final sequencial = " + obj.Resultado());

        passo = (fim - inicio + 1) / 2;
        t1 = new Exemplo1(1, inicio, inicio + passo);
        t2 = new Exemplo1(2, inicio + passo + 1, fim);

        t1.start();
        t2.start();

        t1.join(); // join serve para a thread principal ficar bloqueada ate a thread 2 retornar
        t2.join();

        System.out.println("Soma final paralela = " + (t1.Resultado() + t2.Resultado()));

    }
}