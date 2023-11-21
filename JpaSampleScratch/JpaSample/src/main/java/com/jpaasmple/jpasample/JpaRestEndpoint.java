package com.jpaasmple.jpasample;


import com.jpaasmple.jpasample.db.Film;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("jpa")
public class JpaRestEndpoint {

    @EJB
    private JpaService jpaService;

    @GET
    public String ping() {
        return "Ping successfully";
    }

    @GET
    @Path("films")
    public List<Film> findFilms() {
        return jpaService.findFilms();
    }
}