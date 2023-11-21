/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fish.payara.cd.jpa.quickjakartaee.controller;

import fish.payara.cd.jpa.quickjakartaee.entity.Film;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Gaurav Gupta
 */
@Stateless
public class FilmController {
    
    @PersistenceContext
    public EntityManager manager;
    
    public List<Film> listOfFilms() {
        return manager.createNamedQuery("Film.findAll", Film.class).getResultList();
    }  

}
