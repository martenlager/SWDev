package piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {
    public String translate(String src) {
        if (src == null) {
            throw new NullPointerException();
        }
        if (src.isEmpty()) {
            return src;
        }
        boolean firstUpper = Character.isUpperCase(src.charAt(0));
        
        String lower = src.toLowerCase().trim();
        String pig;
        Pattern consonant = Pattern.compile("^([^aeouiy]+)(.*)");
        Matcher matcher = consonant.matcher(lower);
        if (matcher.matches()) {
            String consonantGroup = matcher.group(1);
            String theRest = matcher.group(2);
            if (theRest.endsWith(consonantGroup)) {
                pig = theRest + "ay";
            } else {
                pig = theRest + consonantGroup + "ay";
            }
        } else {
            pig = lower + "way";
        }
        if(firstUpper)
        	return Character.toUpperCase(pig.charAt(0)) + pig.substring(1);
        else
        	return pig;
    }
}
