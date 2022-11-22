
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Header;
import java.util.Optional;


public interface IHeader {
    
    public void crearHeader(Header header);
    public Optional<Header> verHeader(long id);
    public void editarHeader (Header header);
    
}
