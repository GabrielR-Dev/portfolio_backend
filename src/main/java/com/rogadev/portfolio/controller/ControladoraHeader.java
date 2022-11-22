
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.services.HeaderService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/header")
public class ControladoraHeader {
    
    @Autowired
    private HeaderService headerService;
    
    @PostMapping("/post")
    public void cearHeader(@RequestBody Header header){
        headerService.crearHeader(header);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public Optional<Header> verHeader(long id){
        return headerService.verHeader(id);
    }
    
    @PostMapping("/editar")
    public void editarHeader(@RequestBody Header header){
        headerService.editarHeader(header);
    } 
    
}
