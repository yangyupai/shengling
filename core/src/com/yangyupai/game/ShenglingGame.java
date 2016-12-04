package com.yangyupai.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.core.Global;
import com.yangyupai.game.datas.Cards;
import com.yangyupai.game.models.Card;
import com.yangyupai.game.models.User;
import com.yangyupai.game.screens.MenuScreen;

import java.util.ArrayList;
import java.util.List;

public class ShenglingGame extends Game {

    @Override
    public void create() {

        if (Global.isFirstInGame()) {
            //如果是第一次进入游戏，就从初始数据中生成卡牌，并存入数据库
            List<Card> initCardList = Cards.getAllCardData();
            for (Card card : initCardList) {
                System.out.println("Card:" + card);
                card.save();
            }
        }

        Global.currentUser = new User();
        Global.currentUser.init();

        this.setScreen(new MenuScreen(this));
    }
}
