package piglatin;

public class PigLatinSentenceTranslator {
    public String translateSentence(String src) {
        if (src == null) {
            throw new NullPointerException();
        }
        if (src.isEmpty()) {
            return src;
        }
        if (src.charAt(0) == '.')
            return ".";


        int length = src.length();

        boolean addSentenceEnd = false;
        //System.out.println("");
        //System.out.println(src);
        if (src.charAt(length - 1) == '.') {
            System.out.println("in loop!");
            src = src.substring(0, src.length() - 1);
            addSentenceEnd = true;
        }
        //System.out.println("");
        //System.out.println(src);
        String[] words = src.split(" ");


        String strOutput = "";
        PigLatinTranslator plt = new PigLatinTranslator();
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            strOutput = strOutput.concat(plt.translate(words[i])).concat(" ");


            //words[i] = words[i].replaceAll("[^\\w]", "");
        }

        strOutput = strOutput.trim();
        if (addSentenceEnd)
            strOutput = strOutput.concat(".");
        //System.out.println("Result: " + strOutput);
        return strOutput.trim();
    }
}
