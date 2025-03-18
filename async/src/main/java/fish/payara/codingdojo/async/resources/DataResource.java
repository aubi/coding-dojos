/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.codingdojo.async.resources;

import fish.payara.codingdojo.async.resources.model.Data;
import jakarta.ejb.EJB;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
@Path("data")
public class DataResource {

    @EJB
    private DataService service;
    @POST
    public void storeData(Data data) {
        service.processData(data);
    }
}
