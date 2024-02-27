/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fish.payara.factorial.jsf;

import fish.payara.bean.FactorialService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.util.List;

/**
 *
 * @author aubi
 */
@Named(value = "factorialBean")
@RequestScoped
public class FactorialBean {

    private String input;
    private List<String> outputs;

    @Inject
    FactorialService factorialService;

    /**
     * Creates a new instance of FactorialBean
     */
    public FactorialBean() {
    }

    public void calculate() {
        factorialService.makeFactorial(input);

    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<String> outputs) {
        this.outputs = outputs;
    }

}
