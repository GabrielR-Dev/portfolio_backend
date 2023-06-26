/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rogadev.portfolio.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcercaDeDTO implements Serializable{
    
    private Long idAcercaDe;
    
    @NotBlank
    @Size(min = 3, max = 30)
    private String nombreUsuario;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String tituloDev;
    
    @NotBlank
    @Size(min = 3, max = 250)
    private String descripcionUsu;

    //private Usuarios usuario;
}
