/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.logisitica.service;

import com.demo.logisitica.entity.Entrega;
import com.demo.logisitica.repository.EntregaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author feyin
 */
@SpringBootTest
public class EntregaServiceTest {

    @Mock
    private EntregaRepository entregaRepository;

    @InjectMocks
    private EntregaService entregaService;

    @BeforeEach
    void setMockOutput() {
        when(entregaRepository.save(any(Entrega.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    void testGuardarEntregaConDescuentoTerrestre() {
        Entrega entrega = new Entrega();
        entrega.setTipo("1"); // Suponiendo que 1 significa terrestre
        entrega.setCantidad(11); // Cantidad que califica para el descuento
        entrega.setPrecioEnvio(new BigDecimal("100.00")); // Precio original

        Entrega result = entregaService.saveEntrega(entrega);

        assertEquals(new BigDecimal("95.00"), result.getPrecioEnvio()); // Verifica el descuento del 5%
    }

    @Test
    void testGuardarEntregaSinDescuentoTerrestre() {
        Entrega entrega = new Entrega();
        entrega.setTipo("1"); // 1 es Terrestre
        entrega.setCantidad(10); // Cantidad que NO aplica para el descuento
        entrega.setPrecioEnvio(new BigDecimal("100.00")); // Precio original

        Entrega result = entregaService.saveEntrega(entrega);

        assertEquals(new BigDecimal("100.00"), result.getPrecioEnvio()); // Verifica que no se aplica descuento
    }

    @Test
    void testGuardarEntregaConDescuentoMaritimo() {
        Entrega entrega = new Entrega();
        entrega.setTipo("2"); //  2 es marítimo
        entrega.setCantidad(11); // Cantidad que aplica para el descuento
        entrega.setPrecioEnvio(new BigDecimal("100")); // Precio original

        Entrega result = entregaService.saveEntrega(entrega);

        assertEquals(new BigDecimal("97"), result.getPrecioEnvio()); // Verifica el descuento del 3%
    }

    
}