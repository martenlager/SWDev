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
                new String[]{"tay", "t"},
                new String[]{"qay", "q"},
                new String[]{"Eway", "E"}
        };
        testTranslations(pairs);
    }

    @Test
    public void consonantRule() {
        String[][] pairs = new String[][]{
                new String[]{"igpay", "pig"},
                new String[]{"Atinlay", "Latin"},
                new String[]{"ananabay", "banana"},
                new String[]{"appyhay", "happy"},
                new String[]{"uckday", "duck"},
                new String[]{"atinlay", "latin"},
                new String[]{"opestday", "dopest"},
                new String[]{"emay", "me"},
                new String[]{"ootay", "too"}
        };
        testTranslations(pairs);
    }

    @Test
    public void vowelRule() {
        String[][] pairs = new String[][]{
                new String[]{"eatway", "eat"},
                new String[]{"Omeletway", "Omelet"},
                new String[]{"areway", "are"},
                new String[]{"eggway", "egg"}
        };
        testTranslations(pairs);
    }

    @Test
    public void consonantClusterRule() {
        String[][] pairs = new String[][]{
                new String[]{"ashtray", "trash"},
                new String[]{"Oveglay", "Glove"},
                new String[]{"anksthay", "thanks"},
                new String[]{"estay", "test"},
                new String[]{"eerschay", "cheers"},
                new String[]{"Eshay", "Shesh"},
                new String[]{"ilesmay", "smile"}
        };
        testTranslations(pairs);
    }

    private void testTranslations(String[][] translationPairs) {
        for (String[] pair : translationPairs) {
            assertEquals(pair[0], plt.translate(pair[1]));
        }
    }
}
