import java.util.List;
import java.util.ArrayList;
/**
 * Takes and prints a list of list of sentences in the given order separated by a new line character.
 */
public class ResultPrinter {

    private final List<List<String>> sentencesList;

    public ResultPrinter(List<List<String>> sentencesList) {
        this.sentencesList = sentencesList;
    }

    public void start() {
        // Prints each shift of each sentence in lower case form and calls the method to EditLines.
        List<String> sentences = new ArrayList<>();
        List<String> sentences2 = new ArrayList<>();

        sentencesList.stream().flatMap(List::stream).map(String::toLowerCase).forEach((e) -> sentences.add(e));
        sentences2 = sentences;
        sentences2 = new EditLines(sentences2).start();
        sentences2.forEach(System.out::println);
    }
}
