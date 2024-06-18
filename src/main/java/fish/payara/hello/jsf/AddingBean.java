/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.hello.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author aubi
 */
@Named
@SessionScoped
public class AddingBean implements Serializable {

    private double result;
    private List<Double> history = new ArrayList<>();
    private ListDataModel<Double> historyDataModel;
    
    private Double valueA;

    @PostConstruct
    public void init(){
        historyDataModel = new ListDataModel<>(history);
    }

    public void removeNum(){
        history.remove(historyDataModel.getRowData());
    }

    public void calc() {
        history.add(valueA);
        result = history.stream().reduce(Double::sum).get();
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
