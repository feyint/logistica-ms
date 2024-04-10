/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.logisitica.service;

import com.demo.logisitica.entity.Entrega;
import com.demo.logisitica.entity.EntregaMaritima;
import com.demo.logisitica.entity.EntregaTerrestre;
import com.demo.logisitica.repository.EntregaRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author feyin
 */
@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public List<Entrega> findAllEntregas() {
        return entregaRepository.findAll();
    }

    public Optional<Entrega> findEntregaById(Long id) {
        return entregaRepository.findById(id);
    }

    public Entrega saveEntrega(Entrega entrega) {
    BigDecimal precioEnvioOriginal = entrega.getPrecioEnvio();
    Integer cantidad = entrega.getCantidad();
    
    // Determinar si la entrega es terrestre o marítima y aplicar descuento
//    if (entrega instanceof EntregaTerrestre) {
//        BigDecimal precioConDescuento = calcularDescuentoTerrestre(cantidad, precioEnvioOriginal);
//        entrega.setPrecioEnvio(precioConDescuento);
//    } else if (entrega instanceof EntregaMaritima) {
//        BigDecimal precioConDescuento = calcularDescuentoMaritimo(cantidad, precioEnvioOriginal);
//        entrega.setPrecioEnvio(precioConDescuento);
//    }
    
    // Guardar la entrega con el precio de envío actualizado
    return entregaRepository.save(entrega);
}


    public void deleteEntrega(Long id) {
        entregaRepository.deleteById(id);
    }
    
    public BigDecimal calcularDescuentoTerrestre(Integer cantidad, BigDecimal precioEnvio) {
        if (cantidad > 10) {
            // Aplicar un descuento del 5%
            BigDecimal descuento = precioEnvio.multiply(new BigDecimal("0.05"));
            return precioEnvio.subtract(descuento);
        }
        return precioEnvio;
    }

    public BigDecimal calcularDescuentoMaritimo(Integer cantidad, BigDecimal precioEnvio) {
        if (cantidad > 10) {
            // Aplicar un descuento del 3%
            BigDecimal descuento = precioEnvio.multiply(new BigDecimal("0.03"));
            return precioEnvio.subtract(descuento);
        }
        return precioEnvio;
    }
}
