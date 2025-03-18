/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.codingdojo.async.resources;

import fish.payara.codingdojo.async.resources.model.Data;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
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
    
    @Resource
    private ManagedExecutorService execService;
    
    @Path("/async")
    @POST
    public void asynStoreData(Data data) {
        service.asynProcessData(data);
    }
    
    @Path("/exec")
    @POST
    public void execStoreData(Data data) {
        execService.execute(() -> service.execProcessData(data));
    }

    @Inject
    JMSContext ctx;
    @Resource(lookup = "java:global/queue/msgQueue")
    Queue queue;
    @Path("/jms")
    @POST
    public void message(Data data) {
        ctx.createProducer().send(queue, data);
    }
}
