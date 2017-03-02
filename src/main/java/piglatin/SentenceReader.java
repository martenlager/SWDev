package piglatin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SentenceReader {

    public List<String> read(InputStream stream) throws IOException {
        List<String> sentences = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            while (true) {
                String sentence = br.readLine();
                if (sentence == null) {
                    return sentences;
                }
                sentences.add(sentence);
            }
        }
    }

    public List<String> readFortunes() throws IOException {
        return read(SentenceReader.class.getResourceAsStream("fortunes.txt"));
    }
}
