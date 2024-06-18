/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.hello.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author aubi
 */
@Named
@RequestScoped
public class AddingBean {

    private double a;
    private double b;
    private double result;

    public void calc() {
        result = a + b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
