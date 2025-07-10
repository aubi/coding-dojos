import dev.langchain4j.model.ollama.OllamaChatModel;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String modelName = "smollm:135m";

        OllamaChatModel client = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName(modelName)
                .build();

        String response = client.generate("What is Payara?");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to Country...");
        String country = scanner.nextLine();

        String response2 =
                client.generate("List down unique city names which are good for travelling for couples of " + country +
                        "?");
        System.out.println(response2);


        System.out.println(response);
    }
}

// Run inside container shell
// ollama list
// ollama pull deepseek-r1
