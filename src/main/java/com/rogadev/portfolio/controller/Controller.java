
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.services.AcercaDeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private AcercaDeService adsService;
    
    @PostMapping("/acercade/post")
    public void crearAcercaDe (@RequestBody AcercaDe ads){
        adsService.crearAcercaDe(ads);
    };
   
    @GetMapping("ver/acercade")
    @ResponseBody
    public List<AcercaDe> verAcercaDe(){
        return adsService.verAcercaDe();
    }
    
    
    
}
