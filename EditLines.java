import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Scanner;

/**
 * Takes a list of sentences from the {@link InputReader} and turns it into a list of list of sentences containing the
 * circular shifts of each sentence. Then, it starts the {@link Alphabetizer} module passing it the result.
 */
public class EditLines {

    private final List<String> sentences;

    public EditLines(List<String> sentences) {
        this.sentences = sentences;
    }

    public List<String> start() {
        // Turn each sentence string into a list of lists of sentences, where each sublist contains the shifts of each
        // sentence.
        int counter = 0;
        String deleteLine = "";
        int ListSize = sentences.size();
        int Result = 0;
        while (!deleteLine.equalsIgnoreCase("q") && !sentences.isEmpty()) {
            counter = 0;
            ListSize = sentences.size();
            System.out.print("Escriba el numero de linea que quiere borrar: (o 'q' para salir) => \n");
            for (int i = 0; i < ListSize; i++) {
                System.out.println("Line #" + i + ": " + sentences.get(i));
            }
            Scanner input = new Scanner(System.in);
            deleteLine = input.nextLine();
            if (!deleteLine.equalsIgnoreCase("q") && !deleteLine.isEmpty() && !sentences.isEmpty()) {
                Result = Integer.parseInt(deleteLine);
                if (Result >= 0 && Result < ListSize){
                    sentences.remove(Result);
                }
            }
        }

        return sentences;
    }
}
