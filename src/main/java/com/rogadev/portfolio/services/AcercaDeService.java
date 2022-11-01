
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeService implements IAcercaDe{
    
    @Autowired
    public AcercaDeRepository a;

    @Override
    public void crearAcercaDe(AcercaDe acercade) {
        a.save(acercade);
    }

    @Override
    public List<AcercaDe> verAcercaDe() {
        return (List<AcercaDe>) a.findAll();
    }

    @Override
    public void editarAcercaDe(AcercaDe acercade) {

    }
    
}
