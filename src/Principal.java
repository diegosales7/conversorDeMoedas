import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        System.out.println("Bem-vindo ao Conversor de Moedas!\n");

        do {

            System.out.println("Escolha a moeda que você tem:");
            System.out.println("BRL - Real Brasileiro\nUSD - Dólar\nEUR - Euro\nGBP - Libra\nCNY - Yuan Chinês\nCHF - Franco Suíço\nJPY - Iene Japonês");
            String moedaOrigem = scanner.next().toUpperCase();
            scanner.nextLine(); // limpar buffer


            System.out.println("Escolha a moeda de destino!");
            System.out.println("BRL - Real Brasileiro\nUSD - Dólar\nEUR - Euro\nGBP - Libra\nCNY - Yuan Chinês\nCHF - Franco Suíço\nJPY - Iene Japonês");
            System.out.println("Digite a moeda que você deseja: ");
            String moedaDestino = scanner.next().toUpperCase();
            scanner.nextLine(); // limpar buffer


            System.out.println("Digite o valor que deseja converter:");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // limpar buffer


            double taxa = ApiService.buscarTaxa(moedaOrigem, moedaDestino);

            if (taxa > 0) {
                double valorConvertido = valor * taxa;
                System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaDestino);
            } else {
                System.out.println("Erro ao buscar a taxa. Verifique se a moeda está correta.");
            }


            System.out.println("\nDeseja fazer outra conversão? (sim/não)");
            continuar = scanner.nextLine().trim().toLowerCase();

        } while (continuar.equals("s") || continuar.equals("sim"));

        System.out.println("Encerrando o conversor. Até a próxima!");
        scanner.close();
    }
}