/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.logisitica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author feyin
 */
@Entity(name = "entregas_terrestres")
public class EntregaTerrestre extends Entrega{
    
   
    @ManyToOne
    private Bodega bodegaEntrega;
    
    @ManyToOne
    private Entrega entrega;

    private String placaVehiculo;

    public Bodega getBodegaEntrega() {
        return bodegaEntrega;
    }

    public void setBodegaEntrega(Bodega bodegaEntrega) {
        this.bodegaEntrega = bodegaEntrega;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }


    
}

