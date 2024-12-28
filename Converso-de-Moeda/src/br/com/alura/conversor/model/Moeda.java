package br.com.alura.conversor.model;

public record Moeda(String base_code, String time_last_update_utc, ConversionRates conversion_rates) {

    public record ConversionRates(
        double USD, // Dólar Americano
        double EUR, // Euro
        double GBP, // Libra Esterlina
        double BRL, // Real Brasileiro
        double JPY, // Iene Japonês
        double AUD, // Dólar Australiano
        double CAD, // Dólar Canadense
        double CHF, // Franco Suíço
        double CNY  // Yuan Chinês
    ){}
}
