package piglatin;

public class PigLatinTranslator {
    public String translate(String src) {
        if (src == null) {
            throw new NullPointerException();
        }
        if (src.isEmpty()) {
            return src;
        }
        String lc = src.toLowerCase();
        String pl = lc.substring(1) + lc.substring(0, 1) + "ay";
        return Character.toUpperCase(pl.charAt(0)) + pl.substring(1);
    }
}
