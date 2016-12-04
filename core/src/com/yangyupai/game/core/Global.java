package com.yangyupai.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class Global {
    public static final int GAMEWIDTH = 800;
    public static final int GAMEHEIGHT = 600;
    private static long firstInTime = 0;

    public static boolean isFirstInGame() {
        Preferences init = Gdx.app.getPreferences("init");
        firstInTime = init.getLong("firstTime", 0);
        if (firstInTime == 0) {
            firstInTime = System.currentTimeMillis();
            init.putLong("firstTime", firstInTime);
            init.flush();
            return true;
        } else {
            return false;
        }
    }

    public static long getFirstInTime() {
        return firstInTime;
    }
}
