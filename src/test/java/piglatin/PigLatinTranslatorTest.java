package piglatin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {

    private PigLatinTranslator plt;

    @Before
    public void createTranslator() {
        plt = new PigLatinTranslator();
    }

    @Test
    public void emptyWord() {
        assertEquals("", plt.translate(""));
    }

    @Test(expected = NullPointerException.class)
    public void nullWord() {
        plt.translate(null);
    }

    @Test
    public void oneCharWord() {
        String[][] pairs = new String[][]{
                new String[]{"Tay", "t"},
                new String[]{"Qay", "q"},
                new String[]{"Eay", "E"}
        };
        testTranslations(pairs);
    }

    @Test
    public void rule1() {
        String[][] pairs = new String[][]{
                new String[]{"Igpay", "pig"},
                new String[]{"Atinlay", "Latin"},
                new String[]{"Ananabay", "banana"},
                new String[]{"Appyhay", "happy"},
                new String[]{"Uckday", "duck"},
                new String[]{"Atinlay", "latin"},
                new String[]{"Opestday", "dopest"},
                new String[]{"Emay", "me"},
                new String[]{"Ootay", "too"},
        };
        testTranslations(pairs);
    }

    private void testTranslations(String[][] translationPairs) {
        for (String[] pair : translationPairs) {
            assertEquals(pair[0], plt.translate(pair[1]));
        }
    }
}
