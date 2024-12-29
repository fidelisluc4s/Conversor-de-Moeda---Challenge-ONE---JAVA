package br.com.alura.conversor.model;

public class ConversorMoeda {

    public static double converter(MoedaFiltrada moeda, String origem, String destino, double valor) {
        try {
            double taxaOrigem = obterTaxa(moeda, origem);
            double taxaDestino = obterTaxa(moeda, destino);

            return (valor / taxaOrigem) * taxaDestino;
        }catch (IllegalAccessException e){
            throw new RuntimeException("erro na conversão: " +e.getMessage());
        }
    }

    public static double obterTaxa(MoedaFiltrada moeda, String codigoMoeda) throws IllegalAccessException {
        return switch (codigoMoeda.toUpperCase()) {
            case "USD" -> moeda.USD();
            case "EUR" -> moeda.EUR();
            case "ARS" -> moeda.ARS();
            case "BRL" -> moeda.BRL();
            case "BOB" -> moeda.BOB();
            case "CLP" -> moeda.CLP();
            case "COP" -> moeda.COP();
            case "CHF" -> moeda.COP();
            case "CNY" -> moeda.COP();
            default -> throw new IllegalAccessException("moeda não suportada: " + codigoMoeda);
        };

    }
}
