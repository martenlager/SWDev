package piglatin;

public class PigLatinTranslator {
    public String translate(String src) {
        if (src == null) {
            throw new NullPointerException();
        }
        if (src.isEmpty()) {
            return src;
        }
        String lower = src.toLowerCase();
        String pig;
        if (lower.matches("[aeoui].*")) {
            pig = lower + "way";
        } else {
            pig = lower.substring(1) + lower.charAt(0) + "ay";
        }
        return Character.toUpperCase(pig.charAt(0)) + pig.substring(1);
    }
}
