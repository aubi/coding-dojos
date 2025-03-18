/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.codingdojo.async.resources;

import fish.payara.codingdojo.async.resources.model.Data;
import jakarta.ejb.Stateless;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
@Stateless
public class DataService {
    public void processData(Data data) {
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException ex) {
            Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
