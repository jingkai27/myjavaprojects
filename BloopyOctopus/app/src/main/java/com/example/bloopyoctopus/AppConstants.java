package com.example.bloopyoctopus;

import android.content.Context;

public class AppConstants {
    static BitmapBank bitmapBank;

    static GameEngine gameEngine;

    public static void initialization(Context context){
        bitmapBank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine();

    }

    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }
}
