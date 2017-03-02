package piglatin;

import java.util.List;

public class WordProposer {

    private final List<String> alternatives;

    public WordProposer(List<String> alternatives) {
        this.alternatives = alternatives;
    }

    public String proposeWord(int index) {
        if (index > alternatives.size()) {
            index = alternatives.size() - 1;
        }
        return alternatives.get(index);
    }
}
