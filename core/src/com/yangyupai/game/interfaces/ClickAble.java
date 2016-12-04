package com.yangyupai.game.interfaces;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public interface ClickAble {
    public void onTouchDown(float x, float y);

    public void onTouchUp();

    public void onTouchDragged(float x, float y);

    public boolean isXYinMe(float x, float y);
}
