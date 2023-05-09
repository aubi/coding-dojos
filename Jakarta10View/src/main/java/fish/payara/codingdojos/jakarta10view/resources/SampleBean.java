package fish.payara.codingdojos.jakarta10view.resources;

import jakarta.inject.Named;

@Named("sampleBean")
public class SampleBean {
    String name = "James";
    int numberOne;
    int numberTwo;

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
}
