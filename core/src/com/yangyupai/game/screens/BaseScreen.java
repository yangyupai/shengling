package com.yangyupai.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.yangyupai.game.core.Global;
import com.yangyupai.game.interfaces.ClickAble;
import com.yangyupai.game.models.User;
import com.yangyupai.game.utils.InputTrans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public abstract class BaseScreen implements Screen, InputProcessor {

    Game game;

    List<ClickAble> clickAbleList;

    User user;

    public BaseScreen(Game game) {
        this.clickAbleList = new ArrayList<ClickAble>();
        this.game = game;
        Gdx.input.setInputProcessor(this);
        this.user = Global.currentUser;
    }

    public void addClickAble(ClickAble clickAble) {
        this.clickAbleList.add(clickAble);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        float x = InputTrans.getCursorToModelX(Global.GAMEWIDTH, screenX);
        float y = InputTrans.getCursorToModelY(Global.GAMEHEIGHT, screenY);
        for (ClickAble c : clickAbleList) {
            if (c.isXYinMe(x, y)) {
                c.onTouchDown(x, y);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        float x = InputTrans.getCursorToModelX(Global.GAMEWIDTH, screenX);
        float y = InputTrans.getCursorToModelY(Global.GAMEHEIGHT, screenY);
        for (ClickAble c : clickAbleList) {
            if (c.isXYinMe(x, y)) {
                c.onTouchUp();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        float x = InputTrans.getCursorToModelX(Global.GAMEWIDTH, screenX);
        float y = InputTrans.getCursorToModelY(Global.GAMEHEIGHT, screenY);
        for (ClickAble c : clickAbleList) {
            if (c.isXYinMe(x, y)) {
                c.onTouchDragged(x, y);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
