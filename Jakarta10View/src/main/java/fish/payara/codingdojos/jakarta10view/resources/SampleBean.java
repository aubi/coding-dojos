package fish.payara.codingdojos.jakarta10view.resources;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("sampleBean")
@SessionScoped
public class SampleBean implements Serializable {
    String name = "James";
    int numberOne;
    int numberTwo;
    int result;

    public void calculate(){
        result = numberOne + numberTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public int getResult() {
        return result;
    }
}
