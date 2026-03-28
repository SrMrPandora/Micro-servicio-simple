/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.gateway;

/**
 *
 * @author SrMrPandora
 */
class Producto {

    public Long id;
    public String name;
    public double price;

    public Producto() {
    }

    public Producto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
