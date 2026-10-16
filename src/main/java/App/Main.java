package App;

import Dictionary.WordDictionary;
import Game.Game;
import UI.ConsoleUI;

public class Main {
    static void main() {
        WordDictionary wordDictionary = new WordDictionary();
        Game gameSession = new Game(wordDictionary);
        ConsoleUI consoleUI = new ConsoleUI(gameSession);

        while (true) {
            consoleUI.run();
        }
    }
}
