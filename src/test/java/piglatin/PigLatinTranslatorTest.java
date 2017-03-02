package piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {

    @Test
    public void emptyWord() {
        PigLatinTranslator plt = new PigLatinTranslator();
        assertEquals("", plt.translate(""));
        assertEquals(null, plt.translate(null));
    }

    @Test
    public void rule1() {
        PigLatinTranslator plt = new PigLatinTranslator();
        String[][] pairs = new String[][]{
                new String[]{"pig", "Igpay"},
                new String[]{"Latin", "Atinlay"},
                new String[]{"banana", "Ananabay"},
                new String[]{"happy", "Appyhay"},
                new String[]{"duck", "Uckday"},
                new String[]{"latin", "Atinlay"},
                new String[]{"dopest", "Opestday"},
                new String[]{"me", "Emay"},
                new String[]{"too", "Ootay"},
        };
        for (String[] pair : pairs) {
            assertEquals(pair[1], plt.translate(pair[0]));
        }
    }
}
