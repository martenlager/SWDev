package piglatin;

public class PigLatinTranslator {
    public String translate(String src) {
        if (src == null || src.isEmpty()) {
            return src;
        }
        String lc = src.toLowerCase();
        return lc.substring(1, 2).toUpperCase() + lc.substring(2) + lc.substring(0, 1) + "ay";
    }
}
