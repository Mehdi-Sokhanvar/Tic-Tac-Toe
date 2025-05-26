package com.basic.model;

import java.time.LocalDateTime;

public class Game {
    private final Player player1;
    private final Player player2;
    private final String result; // e.g. "Draw", "Player 1 wins"
    private final LocalDateTime date;

    public Game(Player player1, Player player2, String result, LocalDateTime date) {
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
        this.date = date;
    }



    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getResult() {
        return result;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
