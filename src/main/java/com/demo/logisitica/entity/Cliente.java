/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.logisitica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author feyin
 */
@Entity(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String documento; // Podría ser un NIT o cédula, según lo que utilices.
    private String email;
    private String telefono;

    // Relaciones con entregas
    @OneToMany(mappedBy = "cliente")
    private Set<EntregaTerrestre> entregasTerrestres;

    @OneToMany(mappedBy = "cliente")
    private Set<EntregaMaritima> entregasMaritimas;
    
}