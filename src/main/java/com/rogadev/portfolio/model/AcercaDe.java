
package com.rogadev.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "acercade")
@Getter @Setter
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAcercaDe;
    
    @NotNull
    private String nombreUsuario, tituloDev, descripcionUsu;
    
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    
    
    public AcercaDe() {
    }

    public AcercaDe(String nombreUsuario, String tituloDev, String descripcionUsu, Usuario usuario) {
        this.nombreUsuario = nombreUsuario;
        this.tituloDev = tituloDev;
        this.descripcionUsu = descripcionUsu;
        this.usuario = usuario;
    }


    
    
}
