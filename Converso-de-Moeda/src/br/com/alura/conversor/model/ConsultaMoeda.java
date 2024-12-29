package br.com.alura.conversor.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

    private final String apiKey = "18f8d3909df07699620f4919";

    public Moeda buscaMoeda(String moeda){

       URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+moeda);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);
            //return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao obter dados da API."+ e.getMessage() );
        }
    }

    public MoedaFiltrada buscaMoedasFiltradas(String moedaBase) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+moedaBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                //converte o json completo em json objeto para acessar os valores
                JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);
                JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

                //filtando as moedas
                double USD = conversionRates.get("USD").getAsDouble(); // Dólar Americano
                double EUR = conversionRates.get("EUR").getAsDouble(); // Euro
                double ARS = conversionRates.get("ARS").getAsDouble();// Peso argentino
                double BRL = conversionRates.get("BRL").getAsDouble(); // Real Brasileiro
                double BOB = conversionRates.get("BOB").getAsDouble(); // Boliviano boliviano
                double CLP = conversionRates.get("CLP").getAsDouble(); // Peso chileno
                double COP = conversionRates.get("COP").getAsDouble(); // Peso colombiano
                double CHF = conversionRates.get("CHF").getAsDouble(); // Franco Suíço
                double CNY = conversionRates.get("CNY").getAsDouble(); // Yuan Chinês

                return new MoedaFiltrada(
                        json.get("base_code").getAsString(),
                        json.get("time_last_update_utc").getAsString(),
                        USD, EUR, ARS, BRL, BOB, CLP, COP, CHF,CNY);
            }else {
                throw new RuntimeException("Erro na api: " + response.statusCode() + " - " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao obter dados da API."+ e.getMessage() );
        }
    }

}
