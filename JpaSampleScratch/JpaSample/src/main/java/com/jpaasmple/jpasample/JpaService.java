package com.jpaasmple.jpasample;

import com.jpaasmple.jpasample.db.Film;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class JpaService {

    @PersistenceContext
    private EntityManager em;

    public List<Film> findFilms() {
        return em.createNamedQuery("Film.findAll", Film.class).getResultList();
    }
}
