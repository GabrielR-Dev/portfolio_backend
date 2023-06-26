package com.rogadev.portfolio.security.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DtoAuthRespuesta implements Serializable {
    private String accessToken;
    private String tokenType = "Bearer ";

    public DtoAuthRespuesta(String accessToken) {
        this.accessToken = accessToken;
    }
}
