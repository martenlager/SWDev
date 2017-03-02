package piglatin;

import java.util.List;

public class WordProposer {

    private int index;
    private final List<String> alternatives;

    public WordProposer(List<String> alternatives) {
        this.alternatives = alternatives;
        index = alternatives.size() - 1;
    }

    public String getWord(int index) {
        if (index > alternatives.size()) {
            index = alternatives.size() - 1;
        }
        return alternatives.get(index);
    }

    public String proposeWord() {
        index = (index + 1) % alternatives.size();
        return getWord(index);
    }
}
