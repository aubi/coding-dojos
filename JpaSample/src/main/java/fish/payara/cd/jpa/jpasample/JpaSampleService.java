/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package fish.payara.cd.jpa.jpasample;

import fish.payara.cd.jpa.domain.Actor;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * @author aubi
 */
@Stateless
@LocalBean
public class JpaSampleService {

    @PersistenceContext
    private EntityManager em;

    public List<Actor> loadJpaData() {
        TypedQuery<Actor> queryActorFindAll = em.createNamedQuery("Actor.findAll", Actor.class);
        List<Actor> actors = queryActorFindAll.getResultList();

        return actors;
    }


}
