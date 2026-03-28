/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.gateway;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author SrMrPandora
 */


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GatewayResource {

    @Inject
    @RestClient
    ProductoClient productoClient;

    @Inject
    @RestClient
    OrdenClient ordenClient;

    @GET
    @Path("/productos/{id}")
    public Producto getProducto(@PathParam("id") Long id) {
        return productoClient.getById(id);
    }

    @POST
    @Path("/productos")
    public Producto crearProducto(Producto producto) {
        return productoClient.crear(producto);
    }

    @POST
    @Path("/ordenes")
    public Response crearOrden(Long productId) {
        String result = ordenClient.createOrder(productId);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }
}