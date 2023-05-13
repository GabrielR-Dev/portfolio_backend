
package com.rogadev.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @Column(nullable = false, length = 30)
    private String lugar;
    
    @Column(nullable = false, length = 30)
    private String sector; 
    
    @Column(nullable = false, length = 30)
    private String referencia; 
    
    @Column(nullable = false, length = 50)
    private String logoEmpresaImg;
    
    //@Column (columnDefinition = "DATE", nullable = false)
    //@Temporal(javax.persistence.TemporalType.DATE)
    //@JsonFormat (pattern = "dd-MM-yyyy", timezone = "GMT-3")
    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String fechaInicio;
    
    //@Column (columnDefinition = "DATE", nullable= false)
    //@Temporal(javax.persistence.TemporalType.DATE)
    //@JsonFormat (pattern = "dd-MM-yyyy", timezone = "GMT-3")
    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String fechaFinalizacion;
    
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/

    public Experiencia() {
    }

    public Experiencia(String lugar, String sector, String referencia, String logoEmpresaImg, String fechaInicio, String fechaFinalizacion/*, Usuario usuario*/) {
        this.lugar = lugar;
        this.sector = sector;
        this.referencia = referencia;
        this.logoEmpresaImg = logoEmpresaImg;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        //this.usuario = usuario;
    }

    public Experiencia(long idExperiencia, String lugar, String sector, String referencia, String logoEmpresaImg, String fechaInicio, String fechaFinalizacion) {
        this.idExperiencia = idExperiencia;
        this.lugar = lugar;
        this.sector = sector;
        this.referencia = referencia;
        this.logoEmpresaImg = logoEmpresaImg;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

  
}
