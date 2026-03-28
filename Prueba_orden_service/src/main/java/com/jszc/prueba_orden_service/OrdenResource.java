/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jszc.prueba_orden_service;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author javie
 */
@Path("/ordenes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdenResource {
    @Inject
    @RestClient
    ProductoServiceClient productClient;
    
    @POST
    public Response createOrder(Long productId){
        System.out.println("ID recibido: " + productId);
        Producto product =
                productClient.getById(productId);
        if (product == null) {
            return Response.status
                    (Response.Status.NOT_FOUND).build();
        }
        return Response.status
                (Response.Status.CREATED)
                .entity("Producto creado para: " + product.name + " precio del producto es : " + product.price)
                .build();
    }
}
