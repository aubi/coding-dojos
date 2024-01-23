/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.dojo.jms.hello;

import jakarta.ejb.EJB;
import jakarta.inject.Named;

/**
 *
 * @author aubi
 */
@Named
public class CounterBean {
    @EJB
    private TopicCounter counter;

    public long getCount() {
        return counter.checkCounter();
    }
}
