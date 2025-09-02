package fish.payara.coding.dojos;

public class UpperCaseTextStream implements TextStream {
    private TextStream stream;

    public UpperCaseTextStream(TextStream stream) {
        this.stream = stream;
    }

    public String getOutput() {
        return stream.getOutput().toUpperCase();
    }
}
