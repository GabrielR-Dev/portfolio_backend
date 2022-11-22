
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.repository.AcercaDeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeService implements IAcercaDe{
    
    @Autowired
    private AcercaDeRepository acercaDeRepository;

    @Override
    public void crearAcercaDe(AcercaDe acercade) {
        acercaDeRepository.save(acercade);
    }

    @Override
    public Optional<AcercaDe> verAcercaDe(long id) {
        return acercaDeRepository.findById(id);
    }

    @Override
    public void editarAcercaDe(AcercaDe acercade){
        acercaDeRepository.save(acercade);
    }

    public void editarAcercaDe(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
