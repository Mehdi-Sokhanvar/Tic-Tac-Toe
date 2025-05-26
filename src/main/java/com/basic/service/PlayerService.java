package com.basic.service;

import com.basic.model.Player;
import com.basic.model.PlayerType;
import com.basic.model.Symbol;
import com.basic.repository.PlayerRepository;

public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }


    public Player register(String name, PlayerType type, Symbol symbol) {
        Player player = new Player(name, type, symbol);
        repository.save(player);
        return player;
    }

    public Player findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

}
