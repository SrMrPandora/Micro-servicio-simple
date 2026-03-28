/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jszc.prueba_producto_service;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author javie
 */
@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
public class ProductoResource {

    @GET
    @Path("/{id}")
    public Producto getProduct(@PathParam("id") Long id) {

        return Producto.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Producto Crear(Producto producto) {
        producto.persist();
        return producto;
    }
}
