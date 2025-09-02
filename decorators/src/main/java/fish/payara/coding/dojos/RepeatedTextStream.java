package fish.payara.coding.dojos;

public class RepeatedTextStream implements TextStream {
    private String text;

    public RepeatedTextStream(String text, int repeat) {
        this.text = text.repeat(repeat);
    }

    @Override
    public String getOutput () {
        return this.text;
    }
}
