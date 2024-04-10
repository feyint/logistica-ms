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
@Entity(name = "entregas_maritimas")
public class EntregaMaritima extends Entrega{    
    
    @ManyToOne
    private Puerto puertoEntrega;
    
    @ManyToOne
    private Entrega entrega;

    private String numeroFlota;

    public Puerto getPuertoEntrega() {
        return puertoEntrega;
    }

    public void setPuertoEntrega(Puerto puertoEntrega) {
        this.puertoEntrega = puertoEntrega;
    }

    public String getNumeroFlota() {
        return numeroFlota;
    }

    public void setNumeroFlota(String numeroFlota) {
        this.numeroFlota = numeroFlota;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }


    
}

