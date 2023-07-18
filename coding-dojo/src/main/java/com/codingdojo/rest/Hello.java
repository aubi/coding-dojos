package com.codingdojo.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class Hello {

    @GET
    public String greeting() {
        return "Hello! Coding Dojo";
    }
}
