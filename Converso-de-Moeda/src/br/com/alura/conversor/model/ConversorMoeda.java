package br.com.alura.conversor.model;

import java.util.Map;

public class ConversorMoeda {

    private final Map<String, Double> taxas;

    public ConversorMoeda(Map<String, Double> taxas) {
        this.taxas = taxas;
    }

    public double converter(String origem, String destino, double valor) {
        if (!taxas.containsKey(origem) || !taxas.containsKey(destino)){
            throw new IllegalArgumentException("moedas inválidas: "+origem+" ou "+destino);
        }

        double taxaOrigem = taxas.get(origem);
        double taxaDestino = taxas.get(destino);

        return (valor / taxaOrigem) * taxaDestino;
    }

}
