
package com.rogadev.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "acercade")
@Getter @Setter
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAcercaDe;
    
    @NotNull
    String nombreUsuario, tituloDev, descripcionUsu;

    public AcercaDe() {
    }

    public AcercaDe(int idAcercaDe, String nombreUsuario, String tituloDev, String descripcionUsu) {
        this.idAcercaDe = idAcercaDe;
        this.nombreUsuario = nombreUsuario;
        this.tituloDev = tituloDev;
        this.descripcionUsu = descripcionUsu;
    }
    
    
}
