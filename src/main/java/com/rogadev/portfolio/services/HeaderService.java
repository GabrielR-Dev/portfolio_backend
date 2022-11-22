
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.repository.HeaderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderService implements IHeader{
    
    @Autowired
    public HeaderRepository headerRepo;

    @Override
    public void crearHeader(Header header) {
        headerRepo.save(header);
    }

    @Override
    public Optional<Header> verHeader(long id) {
        return headerRepo.findById(id);
    }

    @Override
    public void editarHeader(Header header) {
        headerRepo.save(header);
    }
    
}
