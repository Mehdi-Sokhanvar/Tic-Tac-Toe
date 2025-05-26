package com.basic.repository;

import com.basic.model.Player;

import java.util.*;

public class PlayerRepository {
    private final Map<String, Player> playerMap = new HashMap<>();



    public void save(Player player) {
        playerMap.put(player.getName(), player);
    }

    public List<Player> findAll() {
        return new ArrayList<>(playerMap.values());
    }

    public Optional<Player> findByName(String name) {
        return Optional.ofNullable(playerMap.get(name));
    }
}
