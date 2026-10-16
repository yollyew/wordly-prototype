package Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WordDictionary {
    public String getRandomWord() {
        Random random = new Random();
        int nLine = random.nextInt(100) + 1;

        return getWord(nLine);
    }

    public String getWord(int nLine) {
        try (BufferedReader reader = new BufferedReader(new FileReader("application.dictionary"))) {
            String line = reader.readLine();
            int counter = 1;

            while (line != null) {
                if (counter == nLine) {
                    return line;
                }

                line = reader.readLine();
                counter++;
            }

            return null;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
