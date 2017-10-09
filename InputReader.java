import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> stopWords = readStopWords();
        List<String> sentences = readInput(stopWords);
        String n = "";
        Scanner input = new Scanner(System.in);
        while (!n.equals("1") && !n.equals("2")){
            System.out.print("Escribe 1 para ordenarlo alfabeticamente o 2 para ordenarlo inversamente. => ");
            n = input.nextLine();
        }
        sentences = new EditLines(sentences).start();
        if (!sentences.isEmpty()) {
            new CircularShifter(sentences, n).start();
        } else {
            System.out.println("No input given");
        }
    }

    private List<String> readStopWords() {
        List<String> sentences = new ArrayList<>();
        String sentence = "";
        while (!sentence.equalsIgnoreCase("q")) {
            System.out.print("Escriba sus stop words en cada linea (o 'q' para salir) => ");
            Scanner input = new Scanner(System.in);
            sentence = input.nextLine();
            if (!sentence.equalsIgnoreCase("q") && !sentence.isEmpty()) {
                sentences.add(sentence);
            }
        }

        return sentences;
    }

    private List<String> readInput(List<String> stopWords) {
        List<String> sentences = new ArrayList<>();
        String sentence = "";
        while (!sentence.equalsIgnoreCase("q")) {
            System.out.print("Escribe una oración (o 'q' para salir) => ");
            Scanner input = new Scanner(System.in);
            sentence = input.nextLine();
            List<String> newSentence = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
            sentence = new StopWords(newSentence, stopWords).start();
            if (!sentence.equalsIgnoreCase("q") && !sentence.isEmpty()) {
                sentences.add(sentence);
            }
        }

        return sentences;
    }
}