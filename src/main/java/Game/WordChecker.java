package Game;

import java.util.HashMap;
import java.util.Map;

public class WordChecker {
    public LetterStatus[] check(String s, String t) {
        int pointer = 0;

        LetterStatus[] status = new LetterStatus[s.length()];
        Map<Character, Integer> letterFreq = new HashMap<>();

        while (pointer < s.length()) {
            if (s.charAt(pointer) == t.charAt(pointer)) {
                status[pointer] = LetterStatus.CORRECT;
            }
            else {
                status[pointer] = LetterStatus.ABSENT;
                letterFreq.put(s.charAt(pointer), letterFreq.getOrDefault(s.charAt(pointer), 0) + 1);
            }
            pointer++;
        }

        pointer--;

        while (pointer >= 0) {
            if (status[pointer] == LetterStatus.ABSENT && letterFreq.getOrDefault(t.charAt(pointer), 0) > 0) {
                status[pointer] = LetterStatus.PRESENT;
                letterFreq.put(t.charAt(pointer), letterFreq.get(t.charAt(pointer)) - 1);
            }
            pointer--;
        }

        return status;
    }
}
