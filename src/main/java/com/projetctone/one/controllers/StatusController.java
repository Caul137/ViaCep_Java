package com.projetctone.one.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetctone.one.dtos.EnderecoDto;
import com.projetctone.one.services.EnderecoService;


@RestController 
@RequestMapping("/")
public class StatusController {
    private final EnderecoService viacep;

    public StatusController(EnderecoService viacep){
        this.viacep = viacep;
    }

    @GetMapping("/listar/{cep}")
    public EnderecoDto ListarCep(@PathVariable  String cep) {
        return this.viacep.Consultar(cep);
    }
    
}
