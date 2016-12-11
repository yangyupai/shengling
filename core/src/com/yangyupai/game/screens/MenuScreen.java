package com.yangyupai.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.yangyupai.game.core.Global;
import com.yangyupai.game.utils.ChineseFont;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class MenuScreen extends BaseScreen {

//    private SpriteBatch batch;
    private BitmapFont info;
//    float time = 0;
    private TextButton cardBtn;
    private TextButton battleBtn;

    private Stage stage;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
//        batch = new SpriteBatch();
        info = new ChineseFont()
                .addWords("圣灵传说卡牌战斗页面")
                .setColor(Color.WHITE)
                .setSize(20)
                .generate();
        stage = new Stage(new StretchViewport(Global.GAMEWIDTH, Global.GAMEHEIGHT));
        Gdx.input.setInputProcessor(stage);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = info;
        cardBtn = new TextButton("卡牌页面", style);
        cardBtn.setPosition(Global.GAMEWIDTH / 2, Global.GAMEHEIGHT - 200);
        cardBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new CardScreen(game));
            }
        });
        battleBtn = new TextButton("战斗页面", style);
        battleBtn.setPosition(Global.GAMEWIDTH / 2, Global.GAMEHEIGHT - 300);
        battleBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BattleScreen(game));
            }
        });
        stage.addActor(cardBtn);
        stage.addActor(battleBtn);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        int center = Global.GAMEWIDTH / 2;
//        info.draw(batch, "圣灵传说", center, Global.GAMEHEIGHT - 100);
//        cardBtn.draw(batch, 1);
//        battleBtn.draw(batch, 1);
//        batch.end();
        stage.act();
        stage.draw();

//        time += delta;
//        if (time > 1) {
//            if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.justTouched()) {
//                game.setScreen(new CardScreen(game));
//            }
//        }
    }

    @Override
    public void dispose() {
        info.dispose();
//        batch.dispose();
    }
}
