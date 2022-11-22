
package com.rogadev.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
    
    @Column(columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy",timezone="GMT-3")
    private Date fechaI;
    
    @Column(columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy",timezone="GMT-3")
    private Date fechaFinalizacion;

    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/

    public Educacion() {
    }

    public Educacion(String estudio, String logoImg, String titulo, Date fechaI, Date fechaFinalizacion) {
        this.estudio = estudio;
        this.logoImg = logoImg;
        this.titulo = titulo;
        this.fechaI = fechaI;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    
}
