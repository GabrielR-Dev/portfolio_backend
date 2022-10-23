
package com.rogadev.portfolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "educacion")
@Getter @Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEducacion;
    
    
    String estudio, logoImg, titulo;
    
    Date fechaInicio, fechaFinalizacion;

    public Educacion() {
    }

    public Educacion(long idEducacion, String estudio, String logoImg, String titulo, Date fechaInicio, Date fechaFinalizacion) {
        this.idEducacion = idEducacion;
        this.estudio = estudio;
        this.logoImg = logoImg;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    
}
