
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Proyecto;
import java.util.List;


public interface IProyecto {
    
    public void publicarProyecto(Proyecto proyecto);
    public Proyecto verProyecto(long id);
    public List<Proyecto> verProyectos ();
    public void eliminarProyecto (long id);
}
