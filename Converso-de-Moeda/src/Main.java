import br.com.alura.conversor.model.ConsultaMoeda;
import br.com.alura.conversor.model.ConversorMoeda;
import br.com.alura.conversor.model.MoedaFiltrada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda consultaMoeda = new ConsultaMoeda();
        MoedaFiltrada moedafiltro = consultaMoeda.buscaMoedasFiltradas("EUR");
        ConversorMoeda conversor = new ConversorMoeda(moedafiltro.getConversionRates());
        boolean continuar = true;

        while (continuar){
            System.out.println("==========================================");
            System.out.println("=== Conversor de Moedas === Escolha uma opção! ===");
            System.out.println("1. Converter moedas");
            System.out.println("2. Exibir taxas de câmbio disponíveis");
            System.out.println("3. Sair");

            int opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> {
                    // exibir a lista de moedas disponíveis
                    System.out.println("Moedas disponíveis para conversão:");
                    moedafiltro.getConversionRates().forEach((moeda, taxa) ->
                            System.out.printf("%s: %.4f%n", moeda, taxa));

                    // realizar a conversão
                    System.out.print("\nInforme o valor a ser convertido: ");
                    double valor = leitura.nextDouble();
                    leitura.nextLine();

                    System.out.print("Informe a moeda de origem (ex: BRL): ");
                    String origem = leitura.nextLine().toUpperCase();

                    System.out.print("Informe a moeda de destino (ex: EUR): ");
                    String destino = leitura.nextLine().toUpperCase();

                    try {
                        double resultado = conversor.converter(origem, destino, valor);
                        System.out.printf("O valor convertido de %s para %s é: %.2f%n", origem, destino, resultado);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 2 -> {
                    // exibir taxa de cambio
                    System.out.println("Taxas de câmbio disponíveis:");
                    moedafiltro.getConversionRates().forEach((moeda, taxa) ->
                            System.out.printf("%s: %.4f%n", moeda, taxa));
                }
                case 3 -> {
                    // Sai do programa
                    continuar = false;
                    System.out.println("Obrigado por usar o conversor de moedas!");
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();

        }
    }
}