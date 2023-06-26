/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rogadev.portfolio.interfaces;

import com.rogadev.portfolio.dto.AcercaDeDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;


public interface IAcercaDe {
    public ResponseEntity<AcercaDeDTO> crearAcercaDe (@Valid AcercaDeDTO acercadeDTO);
    public ResponseEntity<AcercaDeDTO> verAcercaDe();
    public ResponseEntity<AcercaDeDTO> editarAcercaDe (@Valid AcercaDeDTO acercadeDTO);
    
}
