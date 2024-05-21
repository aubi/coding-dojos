/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fish.payara.hello.model;

import java.io.Serializable;

/**
 *
 * @author aubi
 */
public class SampleData implements Serializable {
    private int iVal;
    private String sVal;

    public SampleData() {
    }

    public SampleData(int iVal, String sVal) {
        this.iVal = iVal;
        this.sVal = sVal;
    }

    public int getiVal() {
        return iVal;
    }

    public void setiVal(int iVal) {
        this.iVal = iVal;
    }

    public String getsVal() {
        return sVal;
    }

    public void setsVal(String sVal) {
        this.sVal = sVal;
    }

}
