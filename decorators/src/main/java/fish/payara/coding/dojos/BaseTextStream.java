package fish.payara.coding.dojos;

public class BaseTextStream implements TextStream {
    private String text;

    public BaseTextStream(String text) {
        this.text = text;
    }

    @Override
    public String getOutput () {
        return this.text;
    }
}
