package com.basic.util;

import com.basic.model.Player;
import com.basic.model.PlayerType;
import com.basic.model.Symbol;

public class InitializedData {

    public static void init(){
        ApplicationContext.getPlayerService().register("ali", PlayerType.HUMAN, Symbol.O);
        ApplicationContext.getPlayerService().register("mehdi", PlayerType.HUMAN, Symbol.X);
    }

}
