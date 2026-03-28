/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jszc.prueba_orden_service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 
 *
 * @author javie
 */
    @RegisterRestClient
        (baseUri = "http://localhost:8080")
    @Path("/productos")
public interface ProductoServiceClient {

    @GET
    @Path("/{id}")
    Producto getById(@PathParam("id") Long id);
}

