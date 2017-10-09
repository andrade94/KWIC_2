import java.util.List;

/**
 * Takes and prints a list of list of sentences in the given order separated by a new line character.
 */
public class ResultPrinter {

    private final List<List<String>> sentencesList;

    public ResultPrinter(List<List<String>> sentencesList) {
        this.sentencesList = sentencesList;
    }

    public void start() {
        // Prints each shift of each sentence in lower case form.
        sentencesList.stream().flatMap(List::stream).map(String::toLowerCase).forEach(System.out::println);
    }
}
