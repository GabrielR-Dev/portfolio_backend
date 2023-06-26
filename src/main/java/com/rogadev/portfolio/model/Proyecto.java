
package com.rogadev.portfolio.model;

import javax.persistence.*;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.*;

@Entity
@Table(name = "proyectos")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProyecto;
    
    @Column(nullable = false, length = 30)
    private String titulo;
    
    @Column(nullable = false, length = 250)
    private String link;
    
    @Column(nullable = false, length = 250)
    private String proyectoImg;
    
    @Column(nullable = false, length = 250)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;

}
