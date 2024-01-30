/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fish.payara.hello;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 *
 * @author aubi
 */
@Named(value = "counterBean")
@RequestScoped
public class CounterBean {

    @Inject
    private ProcessingManager processingManager;


    /**
     * Creates a new instance of CounterBean
     */
    public CounterBean() {
    }

    public long getCounter() {
        return processingManager.getCounter();
    }

}
