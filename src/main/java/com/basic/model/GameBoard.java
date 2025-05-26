package com.basic.model;

import java.util.Optional;

public class GameBoard {
    private final Symbol[][] grid = new Symbol[3][3];


    public GameBoard() {
        reset();
    }

    public void reset() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = Symbol.EMPTY;
            }
        }
    }

    public boolean makeMove(int row, int col, Symbol symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (grid[row][col] != Symbol.EMPTY) return false;
        grid[row][col] = symbol;
        return true;
    }

    public Optional<Symbol> checkWinner() {
        // rows & cols
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != Symbol.EMPTY && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2])
                return Optional.of(grid[i][0]);

            if (grid[0][i] != Symbol.EMPTY && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])
                return Optional.of(grid[0][i]);
        }
        // diagonals
        if (grid[0][0] != Symbol.EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
            return Optional.of(grid[0][0]);
        if (grid[0][2] != Symbol.EMPTY && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])
            return Optional.of(grid[0][2]);

        return Optional.empty();
    }

    public boolean isFull() {
        for (Symbol[] row : grid) {
            for (Symbol cell : row) {
                if (cell == Symbol.EMPTY) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+---+---+---+\n");
        for (Symbol[] row : grid) {
            sb.append("|");
            for (Symbol cell : row) {
                sb.append(" ").append(cell).append(" |");
            }
            sb.append("\n+---+---+---+\n");
        }
        return sb.toString();
    }
}
