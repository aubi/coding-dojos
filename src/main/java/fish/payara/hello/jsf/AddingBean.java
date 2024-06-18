/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.hello.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubi
 */
@Named
@SessionScoped
public class AddingBean {

    private double result;
    private List<Double> history = new ArrayList<>();
    
    private Double valueA;
    

    public void calc() {
        history.add(valueA);
        result = history.stream().reduce((aDouble, aDouble2) -> aDouble + aDouble2).get();
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public List<Double> getHistory() {
        return history;
    }

    public Double getValueA() {
        return valueA;
    }

    public void setValueA(Double valueA) {
        this.valueA = valueA;
    }
}
