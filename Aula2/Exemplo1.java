import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exemplo1 {
    private int resultado = 0;

    private int Resultado() {
        return resultado;
    }

    int soma(int inicio, int fim) {
        int resultado = 0;
        for (int i = inicio; i <= fim; i++) {
            resultado += i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int inicio, fim;
        Scanner teclado = new Scanner(System.in);
        Exemplo1 obj = new Exemplo1();

        System.out.println("Digite o inicio:");
        inicio = teclado.nextInt();
        System.out.println("Digite o fim:");
        fim = teclado.nextInt();

        System.out.println("Soma = " + obj.soma(inicio, fim));
    }
}