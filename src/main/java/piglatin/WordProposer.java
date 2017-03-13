package piglatin;

import java.util.*;
import java.util.stream.Collectors;

public class WordProposer {
    private int index;
    private final List<String> alternatives;
    private Random random;

  /**
    Constructor.
    @param alternatives Word dictionary
    @param random Random sequence generator
  */
    public WordProposer(List<String> alternatives, final Random random) {
    	SortedSet<String> sentenceSet = new TreeSet<>((o1,o2) -> o1.length()-o2.length());
    	sentenceSet.addAll(alternatives);
    	sentenceSet.addAll(alternatives.stream()
                .flatMap(s -> Arrays.stream(s.split("[^\\p{Alpha}'`]")))
                .filter(word -> word.length() > 1)
                .collect(Collectors.toList()));
    	this.alternatives = new ArrayList<>(sentenceSet);
        this.random = random;
    }

    /**
    Returns a word from one of the alternatives. Chooses the word with index 'index'.
    */ 
    public String getWord(int index) {
        if (index >= alternatives.size()) {
            index = alternatives.size() - 1;
        }
        return alternatives.get(index);
    }

    /**
    Proposes a random word from the alternatives.
    */ 
    public String proposeWord() {
    	int location = (int) (this.alternatives.size()/20*random.nextDouble());
    	location = Math.max(location, 1);
    	index += location;
    	return getWord(index);
    }

    /**
    Checks the size of the dictionary, i.e. how many words there is in the dictionary.
    */ 
    public int getDictionarySize() {
        return alternatives.size();
    }
}
