package piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {
    @Test
    public void emptyWord() {
        PigLatinTranslator plt = new PigLatinTranslator();
        assertEquals("", plt.translate(""));
    }
}
