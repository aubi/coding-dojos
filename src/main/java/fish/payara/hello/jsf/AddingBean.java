/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.hello.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.DataModel;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubi
 */
@Named
@SessionScoped
public class AddingBean implements Serializable {

    private double result;
    private List<Double> history = new ArrayList<>();
    private DataModel<Double> historyDataModel;
    
    private Double valueA;

    @PostConstruct
    public void init(){
    }

    public void removeNum(){
        Double rowData = historyDataModel.getRowData();
        history.remove(rowData);
        refresh();
    }

    public void calc() {
        history.add(valueA);
        refresh();
    }

    private void refresh() {
        result = history.stream().reduce(0d, Double::sum);
        historyDataModel = new ListDataModel<>(history);
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public DataModel<Double> getHistory() {
        return historyDataModel;
    }

    public Double getValueA() {
        return valueA;
    }

    public void setValueA(Double valueA) {
        this.valueA = valueA;
    }
}
