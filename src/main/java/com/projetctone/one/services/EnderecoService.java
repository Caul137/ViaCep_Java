package com.projetctone.one.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.projetctone.one.dtos.EnderecoDto;


@Service 
public class EnderecoService {
    private final Gson gson;
    private final RestTemplate restTemplate = new RestTemplate();

    public EnderecoService(Gson gson) {
        this.gson = gson;
    }

    public EnderecoDto Consultar(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            EnderecoDto jsonResposta = restTemplate.getForObject(url, EnderecoDto.class);
            
            
            return jsonResposta;

        } catch (Exception e) {
            throw new Error("error");
        }
    }

     
    
}
