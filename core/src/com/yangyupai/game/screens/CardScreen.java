package com.yangyupai.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.models.Card;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class CardScreen extends BaseScreen {

    private Card[] cards;

    private Card[] battleCards;

    SpriteBatch batch;

    public CardScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        this.battleCards = new Card[3];
        this.cards = new Card[5];
        this.cards[0] = new Card(new Texture("badlogic.jpg"));
        this.cards[1] = new Card(new Texture("badlogic.jpg"));
        this.cards[2] = new Card(new Texture("badlogic.jpg"));
        this.cards[3] = new Card(new Texture("badlogic.jpg"));
        this.cards[4] = new Card(new Texture("badlogic.jpg"));
        this.cards[0].setName("小明");
        this.cards[1].setName("小红");
        this.cards[2].setName("小刚");
        this.cards[3].setName("小强");
        this.cards[4].setName("小军");
        for (int i = 0; i < cards.length; i++) {
            this.addClickAble(cards[i]);
            cards[i].setListener(new Card.OnClickListener() {
                @Override
                public void onClick(Card card) {
                    for (int j = 0; j < battleCards.length; j++) {
                        if (battleCards[j] == null) {
                            battleCards[j] = card;
                            break;
                        }
                    }
                }
            });
        }


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < cards.length; i++) {
            int x = i * 100;
            int y = 100;
            cards[i].setPosition(x, y);
            cards[i].drawMe(batch);
        }
        for (int i = 0; i < battleCards.length; i++) {
            if (battleCards[i] != null) {
                int x = i * 100;
                int y = 200;
                battleCards[i].setPosition(x, y);
                battleCards[i].drawMe(batch);
            }
        }
        batch.end();
    }
}
