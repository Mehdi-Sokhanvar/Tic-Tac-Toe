package com.basic.repository;

import com.basic.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private final List<Game> gameHistory = new ArrayList<>();

    public void save(Game game) {
        gameHistory.add(game);
    }

    public List<Game> findAll() {
        return gameHistory;
    }
}
