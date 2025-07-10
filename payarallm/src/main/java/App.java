
import com.google.gson.Gson;
import dev.langchain4j.model.ollama.OllamaChatModel;
import java.util.Map;

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

        String response
                =                client.generate("List five unique cities names which are good for travelling for couples of " + country +
                        """
        . Response should be JSON without any additional text (no text before or after the json) in format:
        {
            "cities": [
                {city: "city1", description: "description1"},
                ...
            ]
        }
        """);
        System.out.println(response);
        Map jsonMap = new Gson()
                .fromJson(response, Map.class);

        System.out.println(jsonMap);
    }
}

// Run inside container shell
// ollama list
// ollama pull deepseek-r1
