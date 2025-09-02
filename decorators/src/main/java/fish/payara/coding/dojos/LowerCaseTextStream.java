package fish.payara.coding.dojos;

public class LowerCaseTextStream implements TextStream {

    private TextStream stream;

    public LowerCaseTextStream(TextStream stream) {
        this.stream = stream;
    }

    @Override
    public String getOutput() {
        return stream.getOutput().toLowerCase();
    }
}
