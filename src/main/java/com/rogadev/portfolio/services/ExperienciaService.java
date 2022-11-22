
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperiencia{
    
    @Autowired
    public ExperienciaRepository expRepository;

    @Override
    public void publicarExperiencia(Experiencia exp) {
        expRepository.save(exp);
    }

    @Override
    public Experiencia verExperiencia(long id) {
        return expRepository.findById(id).orElse(null);
    }

    @Override
    public List<Experiencia> verExperiencias() {
        return (List<Experiencia>) expRepository.findAll();
    }

    @Override
    public void eliminarExpriencia(long id) {
        expRepository.deleteById(id);
    }
    
}
