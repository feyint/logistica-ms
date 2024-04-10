/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.logisitica.repository;

import com.demo.logisitica.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author feyin
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
