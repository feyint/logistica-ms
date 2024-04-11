/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.logisitica.entity;

/**
 *
 * @author feyin
 */
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Entity(name = "entrega")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne
    private Producto producto;

    private Integer cantidad;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;

    private BigDecimal precioEnvio;
    private String numeroGuia;

    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne
    private Cliente cliente;
    
    @JoinColumn(name = "puerto_id", referencedColumnName = "id")
    @ManyToOne
    private Puerto puertoEntrega;
    
    @Column(name = "numero_flota")
    private String numeroFlota;
    
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    @ManyToOne
    private Bodega bodegaEntrega;

    private String placa;
    
    private String tipo;    
    
}
