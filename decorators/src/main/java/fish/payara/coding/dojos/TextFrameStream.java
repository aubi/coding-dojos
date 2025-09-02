package fish.payara.coding.dojos;

public class TextFrameStream implements TextStream {
    private TextStream stream;

    public TextFrameStream(TextStream stream) {
        this.stream = stream;
    }

    @Override
    public String getOutput() {
        StringBuilder output = new StringBuilder();
        output.append("-".repeat(stream.getOutput().length() + 4)).append("\n");
        output.append("| ");
        output.append(stream.getOutput());
        output.append(" |").append("\n");
        output.append("-".repeat(stream.getOutput().length() + 4)).append("\n");
        return output.toString();
    }
}
