package Game;

import Dictionary.WordDictionary;

public class Game {
    private final WordDictionary wordDictionary;

    public void run() {
        wordDictionary.getRandomWord();
    }

    public Game(WordDictionary wordDictionary) {
        this.wordDictionary = wordDictionary;
    }
}
