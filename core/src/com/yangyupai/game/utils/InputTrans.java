package com.yangyupai.game.utils;

import com.yangyupai.game.core.Global;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class InputTrans {

    public static float getCursorToModelX(int screenX, int cursorX) {
        return (((float) cursorX) * Global.GAMEWIDTH) / ((float) screenX);
    }

    public static float getCursorToModelY(int screenY, int cursorY) {
        return ((float) (screenY - cursorY)) * Global.GAMEHEIGHT / ((float) screenY);
    }
}
