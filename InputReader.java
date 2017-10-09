import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads sentences from System.in and sends the resulting list to the {@link CircularShifter} module.
 */
public class InputReader {

    public static void main(String[] args) {
        new InputReader().start();
    }

    public void start() {
        List<String> sentences = readInput();

        if (!sentences.isEmpty()) {
            new CircularShifter(sentences).start();
        } else {
            System.out.println("No input given");
        }
    }

    private List<String> readInput() {
        List<String> sentences = new ArrayList<>();
        String sentence = "";
        while (!sentence.equalsIgnoreCase("q")) {
            System.out.print("Escribe una oración (o 'q' para salir) => ");
            Scanner input = new Scanner(System.in);
            sentence = input.nextLine();
            if (!sentence.equalsIgnoreCase("q") && !sentence.isEmpty()) {
                sentences.add(sentence);
            }
        }

        return sentences;
    }
}