package piglatin;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatinSentenceTranslator {

    private static final String NON_ALPHA = "[^\\p{Alpha}]";

    String translateSentence(String src) {
        return Arrays.stream(src.split("(?<=" + NON_ALPHA + ")|(?=" + NON_ALPHA + ")"))
                .map(w -> Pattern.matches(NON_ALPHA + "+", w) ? w : new PigLatinTranslator().translate(w))
                .collect(Collectors.joining(""));
    }

}
