package com.rogadev.portfolio.security.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRespuestaDTO implements Serializable {
    private String token;
    private String type;
}
