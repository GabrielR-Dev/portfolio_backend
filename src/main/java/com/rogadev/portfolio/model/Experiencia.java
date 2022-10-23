
package com.rogadev.portfolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    long idExperiencia;
    
    String lugar, sector, referencia,logoEmpresaImg;
    
    @Temporal(javax.persistence.TemporalType.DATE)
            Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
            Date fechaFinalizacion;

    public Experiencia() {
    }

    public Experiencia(int idExperiencia, String lugar, String sector, String referencia, String logoEmpresaImg, Date fechaInicio, Date fechaFinalizacion) {
        this.idExperiencia = idExperiencia;
        this.lugar = lugar;
        this.sector = sector;
        this.referencia = referencia;
        this.logoEmpresaImg = logoEmpresaImg;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    

}
