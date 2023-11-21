/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fish.payara.cd.jpa.quickjakartaee.cdi;

import fish.payara.cd.jpa.quickjakartaee.controller.FilmController;
import fish.payara.cd.jpa.quickjakartaee.entity.Film;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;

/**
 *
 * @author ilefstathiou
 */
@Named(value = "filmsBean")
@RequestScoped
public class FilmsBean {
    
    @EJB
    private FilmController filmController;
    
    public List<Film> findAll(){
        return filmController.listOfFilms();
    }  
}
