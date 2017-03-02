package piglatin;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class SentenceReaderTest {
    private SentenceReader reader = new SentenceReader();

    @Test(expected = NullPointerException.class)
    public void readEmpty() throws IOException {
        reader.read(null);
    }

    @Test
    public void readLine() throws IOException {
        List<String> list = reader.read(SentenceReaderTest.class.getResourceAsStream("sentence.txt"));
        assertEquals(1, list.size());
        assertEquals("Simple sentence with few words.", list.get(0));
    }

    @Test
    public void readFortunes() throws IOException {
        List<String> list = reader.readFortunes();
        assertFalse("multiple sentences", list.isEmpty());
        for (String fortune : list) {
            assertFalse("non-empty", fortune.isEmpty());
        }
    }
}
