package Game;

import Dictionary.WordDictionary;

public class Game {
    private final WordDictionary wordDictionary;
    private final WordChecker wordChecker;

    private GameStatus gameStatus;
    private String chosenWord;
    private int attempt;

    public void run() {
        gameStatus = GameStatus.RUNNING;
        chosenWord = wordDictionary.getRandomWord();
        attempt = 6;
    }

    public String useAttempt(String userWord) {
        attempt--;
        String s = "";

        for (LetterStatus status : wordChecker.check(chosenWord, userWord)) {
            s += status + " ";
        }

        for (LetterStatus status : wordChecker.check(chosenWord, userWord)) {
            if (attempt > 0 && status != LetterStatus.CORRECT) {
                break;
            } else if (attempt == 0 && status != LetterStatus.CORRECT) {
                gameStatus = GameStatus.LOSE;
            } else {
                gameStatus = GameStatus.WIN;
            }
        }

        return s;
    }

    public GameStatus checkGameStatus() { return this.gameStatus; }
    public int getAttempt() { return this.attempt; }
    public String getChosenWord() { return this.chosenWord; }

    public Game(WordDictionary wordDictionary) {
        this.wordDictionary = wordDictionary;
        this.wordChecker = new WordChecker();
    }
}
