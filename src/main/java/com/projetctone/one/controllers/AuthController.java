package com.projetctone.one.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetctone.one.dtos.UsuarioDto;
import com.projetctone.one.services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDto dto) {
        if ("teste@email.com".equals(dto.getEmail()) && "123456".equals(dto.getSenha())) {

            String token = jwtService.gerarToken(dto.getEmail());
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("E-mail ou senha incorretos!");

    }

}
