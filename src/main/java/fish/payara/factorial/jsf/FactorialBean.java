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
    private String outputs;
    @Inject
    FactorialService factorialService;


    /**
     * Creates a new instance of FactorialBean
     */
    public FactorialBean() {
    }

    public void calculate() {
        StringBuilder builder = new StringBuilder();

        for (String s : factorialService.makeFactorial(input)) {
            builder.append(s);
        }

        this.setOutputs(builder.toString());
    }

    public void calculateParallel() {
        StringBuilder builder = new StringBuilder();

        for (String s : factorialService.calculateParallelFactorial(input)) {
            builder.append(s);
        }

        this.setOutputs(builder.toString());
    }



    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutputs() {
        return outputs;
    }

    public void setOutputs(String outputs) {
        this.outputs = outputs;
    }
}
