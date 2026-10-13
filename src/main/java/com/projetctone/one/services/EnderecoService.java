package com.projetctone.one.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.projetctone.one.dtos.EnderecoDto;

public class EnderecoService {
    private final Gson gson;

    public EnderecoService(Gson gson) {
        this.gson = gson;
    }

    public EnderecoDto Consultar(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResposta = response.body();

            EnderecoDto endereco = gson.fromJson(jsonResposta, EnderecoDto.class);

            return endereco;

        } catch (Exception e) {
            throw new Error("error");
        }
    }
}
