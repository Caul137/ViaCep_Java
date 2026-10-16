package com.projetctone.one.config;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import io.jsonwebtoken.security.Keys;

public class JwtConstants {
public static final String SECRET = "chave-secreta-super-forte-e-longa-para-o-jwt-com-mais-de-trinta-e-dois-caracteres";

    public static SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }
}
