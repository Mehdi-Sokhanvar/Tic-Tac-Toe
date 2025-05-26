package com.basic.util;

import com.basic.repository.GameRepository;
import com.basic.repository.PlayerRepository;
import com.basic.service.GameService;
import com.basic.service.PlayerService;

public class ApplicationContext {

    private  static GameRepository gameRepository;

    private  static PlayerRepository playerRepository;

    private  static GameService gameService;
    private  static PlayerService playerService;

    static {
        gameRepository=new GameRepository();
        playerRepository=new PlayerRepository();

        gameService=new GameService(gameRepository);
        playerService=new PlayerService(playerRepository);
    }


    public static GameService getGameService() {
        return gameService;
    }

    public static PlayerService getPlayerService() {
        return playerService;
    }
}
