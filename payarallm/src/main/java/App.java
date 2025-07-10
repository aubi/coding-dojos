import dev.langchain4j.model.ollama.OllamaChatModel;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String modelName = "llama3";

        OllamaChatModel client = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName(modelName)
                .build();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to Country...");
        String country = scanner.nextLine();

        String response2 =
                client.generate("List five unique cities names which are good for travelling for couples of " + country +
                        """
        . Response should be JSON without any additional text in format:
        {
            "cities": [
                {city: "city1", description: "description1"},
                ...
            ]
        }
        """);
        System.out.println(response2);

    }
}

// Run inside container shell
// ollama list
// ollama pull deepseek-r1
