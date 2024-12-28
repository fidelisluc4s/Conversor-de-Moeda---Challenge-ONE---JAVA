package br.com.alura.conversor.model;

import com.google.gson.Gson;

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

}
