
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Proyecto;
import com.rogadev.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyecto{

    @Autowired
    public ProyectoRepository proyectoRepo;
    
    @Override
    public void publicarProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
    }

    @Override
    public Proyecto verProyecto(long id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> verProyectos() {
        return (List<Proyecto>) proyectoRepo.findAll();
    }

    @Override
    public void eliminarProyecto(long id) {
        proyectoRepo.deleteById(id);
    }
}
