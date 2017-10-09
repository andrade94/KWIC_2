import java.util.Comparator;
import java.util.List;

/**
 * Takes a list of lists of sentences from the {@link CircularShifter} and sorts each sublist alphabetically. When
 * finished, it passes the result to the {@link ResultPrinter}.
 */
public class Alphabetizer {

    private final List<List<String>> sentencesList;

    public Alphabetizer(List<List<String>> sentencesList) {
        this.sentencesList = sentencesList;
    }

    public void start() {
        // Sort each of the list of sentences contained in the sentencesList alphabetically.
        sentencesList.forEach(s -> s.sort(new SentenceComparator()));

        new ResultPrinter(sentencesList).start();
    }

    private static class SentenceComparator implements Comparator<String> {
        @Override
        public int compare(String sentence1, String sentence2) {
            return sentence1.compareToIgnoreCase(sentence2);
        }
    }
}
