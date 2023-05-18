
package com.rogadev.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

import com.rogadev.portfolio.security.model.Usuario;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "educacion")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEducacion;
    
    @Column(nullable = false, length = 30)
    private String estudio;
    @Column(nullable = false, length = 50)
    private String logoImg; 
    @Column(nullable = false, length = 30)
    private String titulo;
    
    //@Temporal(javax.persistence.TemporalType.DATE)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@JsonFormat(pattern="dd-MM-yyyy",timezone="GMT-3", shape = JsonFormat.Shape.STRING)
    //@Column(columnDefinition = "DATE", nullable = false,)
    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String fechaI;
    
    //@Column(columnDefinition = "DATE", nullable = false)
    //@Temporal(javax.persistence.TemporalType.DATE)
    //@JsonFormat(pattern="dd-MM-yyyy",timezone="GMT-3")
    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String fechaF;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}
