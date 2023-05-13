
package com.rogadev.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "acercade"/*, uniqueConstraints = ""*/)
@Getter @Setter
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAcercaDe;
    
    @Column(nullable = false, length = 30)
    private String nombreUsuario;
    
    @Column(nullable = false, length = 50)
    private String tituloDev;
    
    @Column(nullable = false, length = 250)
    private String descripcionUsu;
    
    //@OneToOne
    //@JoinColumn(name = "id_usuario")
    //    private Usuario usuario;

    
    
    public AcercaDe() {
    }

    public AcercaDe(String nombreUsuario, String tituloDev, String descripcionUsu/*, Usuario usuario*/) {
        this.nombreUsuario = nombreUsuario;
        this.tituloDev = tituloDev;
        this.descripcionUsu = descripcionUsu;
        //this.usuario = usuario;
    }

    public AcercaDe(long idAcercaDe, String nombreUsuario, String tituloDev, String descripcionUsu) {
        this.idAcercaDe = idAcercaDe;
        this.nombreUsuario = nombreUsuario;
        this.tituloDev = tituloDev;
        this.descripcionUsu = descripcionUsu;
    }

    



    
    
}
