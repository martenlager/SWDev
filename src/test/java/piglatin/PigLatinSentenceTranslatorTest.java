package piglatin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinSentenceTranslatorTest {

    private PigLatinSentenceTranslator plt;

    @Before
    public void createTranslator() {
        plt = new PigLatinSentenceTranslator();
    }

    @Test
    public void emptyWord() {
        assertEquals("", plt.translateSentence(""));
    }

    @Test(expected = NullPointerException.class)
    public void nullWord() {
        plt.translateSentence(null);
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

    @Test
    public void sentences() {
        String[][] sentence = new String[][]{
                new String[]{"ashtray Oveglay anksthay estay eerschay Eshay ilesmay", "trash Glove thanks test cheers Shesh smile"},
                new String[]{"ashtray Oveglay anksthay estay eerschay Eshay ilesmay.", "trash Glove thanks test cheers Shesh smile."},
                new String[]{"Ashtray oveglay anksthay estay eerschay eshay ilesmay.", "Trash glove thanks test cheers shesh smile."},

        };
        testTranslations(sentence);
    }

    @Test
    public void testComma() {
        testTranslations(new String[][]{
            new String[]{"Ordsway areway onelylay, entencesay areway iresometay.", "Words are lonely, sentences are tiresome."}
        });
    }

    private void testTranslations(String[][] translationPairs) {
        for (String[] pair : translationPairs) {
            assertEquals(pair[0], plt.translateSentence(pair[1]));
        }
    }
}
