/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        OllamaClient client = new OllamaClient("http://localhost:11434");

        String response = client.chat("ollama", "Hello, how are you?");

    }
}

// Run inside container shell
// ollama list
// ollama pull deepseek-r1
