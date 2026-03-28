/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jszc.prueba_producto_service;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
/**
 *
 * @author javie
 */
@Entity
public class Producto extends PanacheEntity{

    public String name;
    public double price;
    
    public Producto () {}
    public Producto (Long id, String name, double price) {
    
        this.name = name;
        this.price = price;
    }
}
