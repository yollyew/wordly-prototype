package UI;

import Game.Game;

import java.util.Scanner;

public class ConsoleUI {
    private final Game gameSession;
    private final Scanner scanner;

    public void run() {
        showStartMenu();

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> gameSession.run();
            case "2" -> System.exit(0);
        }
    }

    private void showStartMenu() {
        System.out.println("\nMain Menu: ");
        System.out.println("1. Start the game. ");
        System.out.println("2. Exit. ");
        System.out.print("\nEnter option number: ");
    }

    public ConsoleUI(Game gameSession) {
        this.gameSession = gameSession;
        this.scanner = new Scanner(System.in);
    }
}
