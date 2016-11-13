package com.yangyupai.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.utils.ChineseFont;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private BitmapFont info;
    float time = 0;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        info = new ChineseFont()
                .addWords("圣灵传说点击开始")
                .setColor(Color.WHITE)
                .setSize(20)
                .generate();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        info.draw(batch, "圣灵传说，点击开始", 200, 200);

        batch.end();

        time += delta;
        if (time > 1) {
            if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.justTouched()) {
                game.setScreen(new CardScreen(game));
            }
        }
    }

    @Override
    public void dispose() {
        info.dispose();
        batch.dispose();
    }
}
