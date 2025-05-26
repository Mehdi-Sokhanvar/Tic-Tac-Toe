package com.basic.util;

import com.basic.model.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    private final GameBoard board = new GameBoard();
    private Player currentUser;

    public static void main(String[] args) {
        InitializedData.init();
        CLI cli = new CLI();
        cli.start();
    }

    public void start() {
        System.out.println("=== Welcome to Tic Tac Toe ===");
        loginMenu();
    }


    private void loginMenu() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = InputUtils.readIntInput(scanner, "Choose an option: ");
            switch (option) {
                case 1 -> login();
                case 2 -> register();

                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }

        }
    }

    private void login() {
        System.out.print("Enter username: ");
        String name = scanner.nextLine();
        currentUser = ApplicationContext.getPlayerService().findByName(name);
        if (currentUser == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("Login successful! Hello, " + currentUser.getName());
            mainMenu();
        }
    }


    private void register() {
        System.out.print("Choose a username: ");
        String name = scanner.nextLine();
        currentUser = ApplicationContext.getPlayerService().register(name, PlayerType.HUMAN, Symbol.X);
        System.out.println("Registration successful! Welcome, " + currentUser.getName());
        mainMenu();
    }


    private void mainMenu() {
        while (true) {
            System.out.println("1. Play with another player");
            System.out.println("2. View My Stats");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> playWithPlayer();
                case 2 -> {
                    Player stats = ApplicationContext.getPlayerService().findByName(currentUser.getName());
                    System.out.printf("Stats for %s: Played=%d, Wins=%d, Losses=%d, Draws=%d%n",
                            currentUser.getName(),
                            stats.getTotalGame(),
                            stats.getWins(),
                            stats.getLosses(),
                            stats.getDraws());
                }
                case 3 -> {
                    currentUser = null;
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void playWithPlayer() {
        System.out.print("Enter name for Player 2: ");
        String name2 = scanner.nextLine();

        Player p2 = ApplicationContext.getPlayerService().findByName(name2);

        if (p2 == null) {
            System.out.println("User not found.");
            return;
        }

        Symbol symbolPlayerOne, symbolPlayerTwo;
        while (true) {
            System.out.print("Choose symbol for Player 1 (X or O): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("X")) {
                symbolPlayerOne = Symbol.X;
                break;
            } else if (input.equals("O")) {
                symbolPlayerOne = Symbol.O;
                break;
            } else {
                System.out.println("Invalid input. Please enter X or O.");
            }
        }
        symbolPlayerTwo = (symbolPlayerOne == Symbol.X) ? Symbol.O : Symbol.X;
        Player p1 = currentUser;

        p1.setSymbol(symbolPlayerOne);
        p2.setSymbol(symbolPlayerTwo);
        board.reset();
        System.out.println("Game Started!");
        System.out.println(board);
        if (currentUser.getName().equalsIgnoreCase(p2.getName())) {
            System.out.println("You cannot play against yourself. Choose a different player.");
            return;
        }


        Player current = p1;
        LocalDateTime start = LocalDateTime.now();
        Optional<Symbol> winner = Optional.empty();

        while (!board.isFull() && winner.isEmpty()) {
            int row, col;
            while (true) {
                System.out.printf("%s's turn (%s). Enter row and column (0-2): ", current.getName(), current.getSymbol());
                String[] parts = scanner.nextLine().trim().split("\s+");
                if (parts.length != 2) {
                    System.out.println("Please enter two numbers separated by space.");
                    continue;
                }
                try {
                    row = Integer.parseInt(parts[0]);
                    col = Integer.parseInt(parts[1]);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter two integers.");
                }
            }

            if (!board.makeMove(row, col, current.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            System.out.println(board);
            winner = board.checkWinner();
            current = current.equals(p1) ? p2 : p1;
        }


        Game game = ApplicationContext.getGameService().createGame(p1, p2, winner, start);
        System.out.println("Game over! " + game.getResult());
        p1.totalGame();
        p2.totalGame();
        if (winner.isPresent()) {
            Symbol winSymbol = winner.get();
            Player winnerPlayer = (p1.getSymbol() == winSymbol) ? p1 : p2;
            Player loserPlayer = (winnerPlayer.equals(p1)) ? p2 : p1;
            winnerPlayer.recordWin();
            loserPlayer.recordLoss();
            System.out.println("🏆 Winner: " + winnerPlayer.getName());
            System.out.println("😢 Loser: " + loserPlayer.getName());
        } else {
            System.out.println("🤝 It's a draw!");
            p2.recordDraw();
            p1.recordDraw();

        }
    }
}
