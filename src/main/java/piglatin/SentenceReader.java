package piglatin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceReader {

    public List<String> read(InputStream stream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            return br.lines().collect(Collectors.toList());
        }
    }

    public List<String> readFortunes() throws IOException {
        return read(SentenceReader.class.getResourceAsStream("fortunes.txt"));
    }
}
