
package com.rogadev.portfolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "educacion")
@Getter @Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEducacion;
    
    
    private String estudio, logoImg, titulo;
    
    private Date fechaInicio, fechaFinalizacion;
    
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/

    public Educacion() {
    }

    public Educacion(String estudio, String logoImg, String titulo, Date fechaInicio, Date fechaFinalizacion) {
        this.estudio = estudio;
        this.logoImg = logoImg;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    
}
