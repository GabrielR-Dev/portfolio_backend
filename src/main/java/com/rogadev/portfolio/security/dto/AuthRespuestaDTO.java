package com.rogadev.portfolio.security.dto;

import lombok.Data;

@Data
public class AuthRespuestaDTO {
    private String token;
    private String type;
}
