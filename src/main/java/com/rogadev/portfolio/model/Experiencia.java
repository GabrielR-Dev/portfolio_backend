
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
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "experiencias")
@Getter @Setter
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExperiencia;
    
    private String lugar, sector, referencia,logoEmpresaImg;
    
    @Temporal(javax.persistence.TemporalType.DATE)
            private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
            private Date fechaFinalizacion;
    
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/

    public Experiencia() {
    }

    public Experiencia(String lugar, String sector, String referencia, String logoEmpresaImg, Date fechaInicio, Date fechaFinalizacion/*, Usuario usuario*/) {
        this.lugar = lugar;
        this.sector = sector;
        this.referencia = referencia;
        this.logoEmpresaImg = logoEmpresaImg;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        //this.usuario = usuario;
    }

  
}
