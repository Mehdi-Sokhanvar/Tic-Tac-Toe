package com.basic.model;

public class Player {

    private final String name;
    private final PlayerType  isComputer;

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private  Symbol symbol;
    private int totalGame;
    private int wins;
    private int losses;
    private int draws;

    public PlayerType getIsComputer() {
        return isComputer;
    }

    public Player(String name, PlayerType isComputer, Symbol symbol) {
        this.name = name;
        this.isComputer = isComputer;
        this.symbol = symbol;
    }


    public void recordWin()  { wins++; }
    public void totalGame()  { totalGame++; }
    public void recordLoss() { losses++; }
    public void recordDraw() { draws++; }


    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getTotalGame() {
        return totalGame;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }
}
