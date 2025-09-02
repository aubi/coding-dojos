package fish.payara.coding.dojos;

public class TextWrapStream implements TextStream {
    private final TextStream stream;
    private final int lineLength;
    
    public TextWrapStream(TextStream stream, int lineLength) {
        this.stream = stream;
        this.lineLength = lineLength;
    }
    
    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        String output = this.stream.getOutput();
        while (output.length() > this.lineLength) {
            builder.append(output, 0, this.lineLength);
            builder.append("\n");
            output = output.substring(this.lineLength);
        }
        builder.append(output);
        return builder.toString();
    }
}
