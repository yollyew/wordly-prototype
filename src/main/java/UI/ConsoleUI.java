package UI;

import Game.Game;
import Game.GameStatus;

import java.util.Scanner;

public class ConsoleUI {
    private final Game gameSession;
    private final Scanner scanner;

    public void run() {
        showStartMenu();

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> showGameMenu();
            case "0" -> System.exit(0);
        }
    }

    private void showStartMenu() {
        System.out.println("\nMain Menu: ");
        System.out.println("1. Start the game. ");
        System.out.println("0. Exit. ");
        System.out.print("\nEnter option number: ");
    }

    private void showGameMenu() {
        gameSession.run();
        System.out.println("\nThe word has chosen. ");
        System.out.println("You have 6 attempts to guess. ");
        System.out.println("Every letter will be emphasize. ");
        System.out.println("CORRECT if letter correctly on his place. ");
        System.out.println("PRESENT if letter is present but not on place. ");
        System.out.println("ABSENT if letter is absent");

        while (gameSession.checkGameStatus() == GameStatus.RUNNING) {
            showGameRunningMenu();
        }

        showGameEndMenu();
    }

    private void showGameRunningMenu() {
        System.out.println("\nAttempts left: " + gameSession.getAttempt());
        System.out.print("\nEnter your try: ");
        String userWord = scanner.nextLine();
        System.out.println(gameSession.useAttempt(userWord));
    }

    private void showGameEndMenu() {
        System.out.println("Chosen word is: " + gameSession.getChosenWord());
        System.out.println("\nYou " + gameSession.checkGameStatus());
    }

    public ConsoleUI(Game gameSession) {
        this.gameSession = gameSession;
        this.scanner = new Scanner(System.in);
    }
}
