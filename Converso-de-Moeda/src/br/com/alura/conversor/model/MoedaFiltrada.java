package br.com.alura.conversor.model;

public record MoedaFiltrada(
        String base_code,
        String time_last_update_utc,
        double USD,
        double EUR,
        double ARS,
        double BRL,
        double BOB,
        double CLP,
        double COP,
        double CHF,
        double CNY
        ) {}

