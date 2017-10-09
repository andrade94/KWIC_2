import java.util.Comparator;
import java.util.List;

/**
 * Takes a list of lists of sentences from the {@link CircularShifter} and sorts each sublist alphabetically. When
 * finished, it passes the result to the {@link ResultPrinter}.
 */
public class Alphabetizer {

    private final List<List<String>> sentencesList;
    private final String order;

    public Alphabetizer(List<List<String>> sentencesList, String order) {
        this.sentencesList = sentencesList;
        this.order = order;
    }

    public void start() {
        // Sort each of the list of sentences contained in the sentencesList alphabetically.
        if (order.equals("1")){
            sentencesList.forEach(s -> s.sort(new AlphabeticSentenceComparator()));
        } else {
            sentencesList.forEach(s -> s.sort(new InverseSentenceComparator()));
        }

        new ResultPrinter(sentencesList).start();
    }

    private static class AlphabeticSentenceComparator implements Comparator<String> {
        @Override
        public int compare(String sentence1, String sentence2) {
            return sentence1.compareToIgnoreCase(sentence2);
        }
    }

    private static class InverseSentenceComparator implements Comparator<String> {
        @Override
        public int compare(String sentence1, String sentence2) {
            return sentence2.compareToIgnoreCase(sentence1);
        }
    }
}
