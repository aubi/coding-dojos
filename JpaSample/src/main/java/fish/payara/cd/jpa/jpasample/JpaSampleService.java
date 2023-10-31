/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package fish.payara.cd.jpa.jpasample;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;

/**
 *
 * @author aubi
 */
@Stateless
@LocalBean
public class JpaSampleService {

    @PersistenceUnit
    private EntityManager em;

    public String loadJpaData() {
        return "TODO";
//        em.createNamedQuery("XYZ", XYZ.class)...
    }
}
