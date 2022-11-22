
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Educacion;
import com.rogadev.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacion{

    @Autowired
    public EducacionRepository educacionRepo;
    
    @Override
    public void publicarEducacion(Educacion educacion) {
        educacionRepo.save(educacion);
    }

    @Override
    public Educacion verEducacion(long id) {
        
        return educacionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Educacion> verEstudios() {
        return (List<Educacion>) educacionRepo.findAll();
    }

    @Override
    public void eliminarEducacion(long id) {
        educacionRepo.deleteById(id);
    }
}
