/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author aubi
 */
@Path("hello")
public interface SampleDataClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@QueryParam("name") String name);

    @Path("data")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response data();

}
