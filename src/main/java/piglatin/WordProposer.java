package piglatin;

import java.util.List;
import java.util.Random;

public class WordProposer {

    private int index;
    private final List<String> alternatives;
    private Random random;

    /**
     * Constructor.
     *
     * @param alternatives Word dictionary
     * @param random       Random sequence generator
     */
    public WordProposer(List<String> alternatives, final Random random) {
        this.alternatives = alternatives;
        index = alternatives.size() - 1;
        this.random = random;
    }

    public String getWord(int index) {
        if (index >= alternatives.size()) {
            index = alternatives.size() - 1;
        }
        return alternatives.get(index);
    }

    public String proposeWord() {
        return getWord(random.nextInt(getDictionarySize()));
    }


    public int getDictionarySize() {
        return alternatives.size();
    }
}
