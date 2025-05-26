package com.basic.service;

import com.basic.model.Game;
import com.basic.model.Player;
import com.basic.model.Symbol;
import com.basic.repository.GameRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository gameRepository) {
        this.repository = gameRepository;
    }

    public Game createGame(Player p1, Player p2, Optional<Symbol> winner, LocalDateTime start) {
        Game game = new Game(p1, p2, winner.toString(), start);
        repository.save(game);
        return game;
    }


}
