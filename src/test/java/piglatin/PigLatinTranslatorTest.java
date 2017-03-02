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
                new String[]{"Eway", "E"}
        };
        testTranslations(pairs);
    }

    @Test
    public void consonantRule() {
        String[][] pairs = new String[][]{
                new String[]{"Igpay", "pig"},
                new String[]{"Atinlay", "Latin"},
                new String[]{"Ananabay", "banana"},
                new String[]{"Appyhay", "happy"},
                new String[]{"Uckday", "duck"},
                new String[]{"Atinlay", "latin"},
                new String[]{"Opestday", "dopest"},
                new String[]{"Emay", "me"},
                new String[]{"Ootay", "too"}
        };
        testTranslations(pairs);
    }

    @Test
    public void vowelRule() {
        String[][] pairs = new String[][]{
                new String[]{"Eatway", "eat"},
                new String[]{"Omeletway", "Omelet"},
                new String[]{"Areway", "are"},
                new String[]{"Eggway", "egg"}
        };
        testTranslations(pairs);
    }

    @Test
    public void consonantClusterRule() {
        String[][] pairs = new String[][]{
                new String[]{"Ashtray", "trash"},
                new String[]{"Oveglay", "Glove"},
                new String[]{"Anksthay", "thanks"},
                new String[]{"Estay", "test"},
                new String[]{"Eerschay", "cheers"},
                new String[]{"Eshay", "Shesh"},
                new String[]{"Ilesmay", "smile"}
        };
        testTranslations(pairs);
    }

    private void testTranslations(String[][] translationPairs) {
        for (String[] pair : translationPairs) {
            assertEquals(pair[0], plt.translate(pair[1]));
        }
    }
}
