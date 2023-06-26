package com.rogadev.portfolio.security.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class DtoRegistro implements Serializable {

    @NotBlank
    @NotNull
    @Email
    private String username;
    @NotBlank
    @Size(min = 4,max = 200)
    private String password;

}
