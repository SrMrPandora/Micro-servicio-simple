/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jszc.prueba_orden_service;

/**
 *
 * @author javie
 */
public class Producto {

    public Long id;
    public String name;
    public double price;
    
    public Producto () {}
    public Producto (Long id, String name, double price) {
    
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

