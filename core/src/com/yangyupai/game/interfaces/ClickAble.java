package com.yangyupai.game.interfaces;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public interface ClickAble {
    public void onTouchDown();

    public void onTouchUp();

    public void onTouchDragged();

    public boolean isXYinMe(float x, float y);
}
