package com.jpaasmple.jpasample;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("jpa")
public class JpaRestEndpoint {

    @GET
    public String ping() {
        return "Ping successfully";
    }
}
