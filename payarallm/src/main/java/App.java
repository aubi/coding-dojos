import dev.langchain4j.model.ollama.OllamaChatModel;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        OllamaChatModel client = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3:latest")
                .build();

        String response = client.generate("What is Payara?");
        System.out.println(response);
    }
}

// Run inside container shell
// ollama list
// ollama pull deepseek-r1
