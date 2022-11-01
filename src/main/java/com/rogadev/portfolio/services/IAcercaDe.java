/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.AcercaDe;
import java.util.List;


public interface IAcercaDe {
    public void crearAcercaDe(AcercaDe acercade);
    public List<AcercaDe> verAcercaDe();
    public void editarAcercaDe (AcercaDe acercade);
    
}
