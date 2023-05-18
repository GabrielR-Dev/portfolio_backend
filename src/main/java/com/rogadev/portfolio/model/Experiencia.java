
package com.rogadev.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;

import com.rogadev.portfolio.security.model.Usuario;
import lombok.*;

@Entity
@Table(name = "experiencias")
@Data
@AllArgsConstructor @NoArgsConstructor
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
    

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}
