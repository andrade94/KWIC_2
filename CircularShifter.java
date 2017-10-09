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
public class CircularShifter {

    private final List<String> sentences;

    public CircularShifter(List<String> sentences) {
        this.sentences = sentences;
    }

    public void start() {
        // Turn each sentence string into a list of lists of sentences, where each sublist contains the shifts of each
        // sentence.
        List<List<String>> sentencesList = sentences.stream()
                .map(s -> flattenPermutations(permutationForSentence(Arrays.asList(s.split(" ")))))
                .collect(Collectors.toList());

        new Alphabetizer(sentencesList).start();
    }

    /**
     * Flattens a list of lists of words into a list of strings concatenating each word with a blank space between them.
     * i.e. List[List["are", "white", "clouds"],
     *           List["white", "clouds", "are"],
     *           List["clouds, "are", "white"]]
     * would return:
     *      List["are white clouds", "white clouds are", "clouds are white"].
     */
    private static List<String> flattenPermutations(List<List<String>> permutations) {
        return permutations.stream()
                .map(p -> String.join(" ", p))
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of circular shifts of a sentence represented as a list of words.
     * i.e. List["clouds", "are", "white"] would return
     *      List[List["are", "white", "clouds"],
     *           List["white", "clouds", "are"],
     *           List["clouds, "are", "white"]]
     */
    private static List<List<String>> permutationForSentence(final List<String> words) {
        return IntStream.rangeClosed(1, words.size())
                .mapToObj(d -> {
                    List<String> copy = new ArrayList<>(words);
                    Collections.rotate(copy, d);
                    return copy;
                })
                .collect(Collectors.toList());
    }
}
