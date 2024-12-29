package br.com.alura.conversor.model;

public record Moeda(String base_code,
                    String time_last_update_utc,
                    MoedaFiltrada conversion_rates)
{}
