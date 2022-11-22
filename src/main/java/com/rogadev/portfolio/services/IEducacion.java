
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Educacion;
import java.util.List;

public interface IEducacion {
    
    public void publicarEducacion(Educacion educacion);
    public Educacion verEducacion(long id);
    public List<Educacion> verEstudios ();
    public void eliminarEducacion (long id);
    
}
