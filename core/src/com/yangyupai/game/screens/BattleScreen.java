package com.yangyupai.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.core.Global;
import com.yangyupai.game.interfaces.CardViewListener;
import com.yangyupai.game.interfaces.ClickAble;
import com.yangyupai.game.models.User;
import com.yangyupai.game.views.CardView;

/**
 * Created by dongwenqiang on 16/12/11.
 */
public class BattleScreen extends BaseScreen {

    SpriteBatch batch;

    private CardView[] myCards;
    private CardView[] enemyCards;

    private User enemy;

    private int centerLine = Global.GAMEHEIGHT / 2;

    public BattleScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();

        //这个用来表示对手，一个示例
        enemy = new User();
        enemy.init();

        myCards = new CardView[3];
        enemyCards = new CardView[3];

        for (int i = 0; i < 3; i++) {
            myCards[i] = new CardView(this.user.getAllMyCards().get(i));
            myCards[i].initView();
            this.addClickAble(myCards[i]);

            float initX = 100 * i + 100;
            float initY = centerLine - 100;
            myCards[i].setInitPosition(initX, initY);
            myCards[i].setPosition(initX, initY);

            myCards[i].setCardViewListener(new CardViewListener() {
                @Override
                public void onClick(CardView cardView) {

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

                    if (y > centerLine) {
                        //当移动的位置到达画面上方，也就是敌人卡牌的区域时，开始检查是否有碰撞。
                        ClickAble collisionCard = checkCollision(cardView);
                        if (collisionCard != null) {
                            //collisionCard是被撞上的卡牌,也就是被攻击的卡牌，cardView是移动的卡牌，也就是攻击者。
                            CardView beCollisionCard = (CardView) collisionCard;
                            System.out.println("Card:" + cardView.getData().getId() + " collision Card:" + beCollisionCard.getData().getId());
                        }
                    }
                }

                @Override
                public void onDragFinish(CardView cardView) {
                    ClickAble collisionCard = checkCollision(cardView);
                    if (collisionCard != null) {
                        //collisionCard是被撞上的卡牌,也就是被攻击的卡牌，cardView是移动的卡牌，也就是攻击者。
                        CardView beCollisionCard = (CardView) collisionCard;
                        System.out.println("Card:" + beCollisionCard.getData().getId() + " is be attacked by " + cardView.getData().getId());
                        System.out.println("Before attack HP is:" + beCollisionCard.getData().getHp());
                        beCollisionCard.getData().beAttack(cardView.getData());
                        System.out.println("After attack HP is:" + beCollisionCard.getData().getHp());
                    }

                    //拖拽完成时，回归初始位置
                    float initX = cardView.getInitX();
                    float initY = cardView.getInitY();
                    cardView.setPosition(initX, initY);
                }
            });
        }

        for (int i = 0; i < 3; i++) {
            enemyCards[i] = new CardView(enemy.getAllMyCards().get(i));
            enemyCards[i].initView();
            this.addCollisionList(enemyCards[i]);

            float initX = 100 * i + 100;
            float initY = centerLine + 100;
            enemyCards[i].setInitPosition(initX, initY);
            enemyCards[i].setPosition(initX, initY);
        }

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        for (int i = 0; i < enemyCards.length; i++) {
            enemyCards[i].drawMe(batch);
        }

        for (int i = 0; i < myCards.length; i++) {
            myCards[i].drawMe(batch);
        }

        batch.end();
    }
}
