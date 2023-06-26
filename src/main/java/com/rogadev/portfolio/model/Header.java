
package com.rogadev.portfolio.model;

import com.rogadev.portfolio.security.model.Usuarios;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Header {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHeader;
    
    @Column(nullable = false, length = 50)
    private String portadaImg;
    
    @Column(nullable = false, length = 100)
    private String frase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", unique = true)
    private Usuarios usuario;

}
