
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.repository.AcercaDeRepository;
import java.util.List;
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
    public List<AcercaDe> verAcercaDe() {
        return acercaDeRepository.findAll();
    }

    @Override
    public void editarAcercaDe(AcercaDe acercade){
        acercaDeRepository.save(acercade);
    }
    

    
}
