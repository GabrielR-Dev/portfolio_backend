
package com.rogadev.portfolio.model;

import com.rogadev.portfolio.security.model.Usuario;
import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
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
    
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}
