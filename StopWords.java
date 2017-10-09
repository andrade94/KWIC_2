import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Takes a list of sentences from the {@link InputReader} and turns it into a list of list of sentences containing the
 * circular shifts of each sentence. Then, it starts the {@link Alphabetizer} module passing it the result.
 */
public class StopWords {

    private final List<String> sentence;
    private final List<String> stopWords;

    public StopWords(List<String> sentence, List<String> stopWords) {
        this.sentence = sentence;
        this.stopWords = stopWords;
    }

    public String start() {
        // Take out all of the stopWords.
        List<String> st = new ArrayList<>(); 
        String newSentence = sentence.stream()
                .filter(s -> !stopWords.contains(s))
                .collect(Collectors.joining(" "));
        return newSentence;
    }
}
