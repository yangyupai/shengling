package com.yangyupai.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.interfaces.CardViewListener;
import com.yangyupai.game.views.CardView;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class CardScreen extends BaseScreen {

    private CardView[] cards;

    private CardView[] battleCards;

    SpriteBatch batch;

    public CardScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();

        cards = new CardView[this.user.getAllMyCards().size()];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new CardView(this.user.getAllMyCards().get(i));
            cards[i].initView();
        }

        this.battleCards = new CardView[3];

        for (int i = 0; i < cards.length; i++) {
            this.addClickAble(cards[i]);
            CardViewListener listener = new cardListener();
            this.cards[i].setCardViewListener(listener);
            int x = i * 100;
            int y = 100;
            cards[i].setPosition(x, y);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < cards.length; i++) {
            cards[i].drawMe(batch);
        }
        for (int i = 0; i < battleCards.length; i++) {
            if (battleCards[i] != null) {
                battleCards[i].drawMe(batch);
            }
        }
        batch.end();
    }

    class cardListener implements CardViewListener {

        @Override
        public void onClick(CardView cardView) {
            for (int i = 0; i < battleCards.length; i++) {
                if (battleCards[i] == null) {
                    battleCards[i] = cardView;
                    int x = i * 100;
                    int y = 200;
                    battleCards[i].setPosition(x, y);
                    break;
                }
            }
        }

        @Override
        public void onDragged(CardView cardView, float x, float y) {
            float lastX = cardView.getPointX();//上一次触摸的x
            float lastY = cardView.getPointY();//上一次触摸的y
            float currentX = cardView.getX();//当前的x
            float currentY = cardView.getY();//当前的y
            float tmpX = x - lastX;//触摸区域的偏移x
            float tmpY = y - lastY;//触摸区域的偏移y

            cardView.setPosition(currentX + tmpX, currentY + tmpY);
        }

        @Override
        public void onDragFinish(CardView cardView) {

        }
    }
}
