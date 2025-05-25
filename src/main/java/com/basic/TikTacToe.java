package com.basic;

import java.util.Scanner;

public class TikTacToe {

//    enum for symbol
//    login use in cli
    private final static char[][] board = new char[3][3];
    private final static char symbolOne = 'X';
    private final static char symbolTwo = 'O';
    private static int currentUser = 1;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IllegalAccessException {
        initializedBoard();
    }

    public static void initializedBoard() throws IllegalAccessException {
        printBoard();
        label:
        while (true) {
            System.out.println("PLAYER ".concat(String.valueOf(currentUser)).concat("CHOOSE YOU INDEX"));
            System.out.print("inter index  Row (1,2,3)::  ");
            int row = scanner.nextInt();
            System.out.print("inter index  Col (1,2,3)::  ");
            int col = scanner.nextInt();
            putUserSelectedIndex(row - 1, col - 1);
            if (checkUserWinner()) {
                System.out.println("Player".concat(String.valueOf(currentUser )).concat("WON"));
                printBoard();
                break label;
            }
            changeCurrentUser();
            printBoard();
        }
    }

    private static boolean checkUserWinner() {
        char symbol = currentUser == 1 ? symbolOne : symbolTwo;
//        changeCurrentUser();
        for (int i = 0; i < 3; i++) {
            if (board[i][0] ==  symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    private static void changeCurrentUser() {
        currentUser = (currentUser == 1) ? 2 : 1;
    }

    private static void putUserSelectedIndex(int row, int col) throws IllegalAccessException {
        checkEmptyIndex(row, col);
        board[row][col] = (currentUser == 1) ? symbolOne : symbolTwo;
    }

    private static void checkEmptyIndex(int row, int col) throws IllegalAccessException {
        if (board[row][col] == symbolOne || board[row][col] == symbolTwo) {
            throw new IllegalAccessException("PLEASE INTER EMPTY INDEX");
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(TikTacToe.board[i][j] + "   ");
            }
            System.out.println();
        }
    }


}
