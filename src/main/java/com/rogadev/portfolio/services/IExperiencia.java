/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author Mi PC
 */
public interface IExperiencia {
    
    public void publicarExperiencia (Experiencia exp);
    public Experiencia verExperiencia (long id);
    public List <Experiencia> verExperiencias();
    public void eliminarExpriencia (long id);
    
}
