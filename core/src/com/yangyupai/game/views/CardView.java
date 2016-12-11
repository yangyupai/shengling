package com.yangyupai.game.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.interfaces.CardViewListener;
import com.yangyupai.game.interfaces.ClickAble;
import com.yangyupai.game.models.Card;

/**
 * Created by dongwenqiang on 16/12/4.
 */
public class CardView implements ClickAble {

    /*
     * 核心数据部分
     */
    private final Card data;

    public CardView(Card data) {
        this.data = data;
    }

    public Card getData() {
        return this.data;
    }

    /*
     * 显示与监听部分
     */

    public static final int NORMAL = 0;
    public static final int TOUCH_DOWN = 1;
    public static final int TOUCH_DRAGGED = 2;

    private Sprite meView;
    private CardViewListener cardViewListener;
    private int status;
    private boolean enableClick = true;
    private boolean enableDrag = true;

    private int cardWidth = 50;
    private int cardHeight = 50;

    private float x = 0;//当前位置x
    private float y = 0;//当前位置y

    private float pointX = 0;//点击的位置x
    private float pointY = 0;//点击的位置y

    public void setCardViewListener(CardViewListener listener) {
        this.cardViewListener = listener;
    }

    public boolean hasListener() {
        return this.cardViewListener != null;
    }

    public void initView() {
        System.out.println(this.data);
        Texture bgTexture = new Texture(this.data.getBg());
        this.meView = new Sprite(bgTexture, cardWidth, cardHeight);
    }

    public void setWidthAndHeight(int width, int height) {
        this.cardWidth = width;
        this.cardHeight = height;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getPointX() {
        return pointX;
    }

    public float getPointY() {
        return pointY;
    }

    public void drawMe(SpriteBatch spriteBatch) {
        this.meView.setPosition(x, y);
        this.meView.getBoundingRectangle().setPosition(x, y);
        this.meView.draw(spriteBatch);
    }

    @Override
    public void onTouchDown(float x, float y) {
        //按下时设置状态为按下
        this.status = TOUCH_DOWN;
        this.pointX = x;
        this.pointY = y;
    }

    @Override
    public void onTouchUp() {
        /*
         * 触屏抬起时，如果之前的状态是被拖动的，则意味着拖动结束，就回调拖动结束方法。
         * 如果之前的状态是被按下，则意味着点击，就回调点击方法。
         */
        if (this.hasListener()) {
            System.out.println("");
            if (this.isDragged() && this.enableDrag) {
                this.cardViewListener.onDragFinish(this);
            } else if (this.isTouchDown() && this.enableClick) {
                this.cardViewListener.onClick(this);
            }
        }
        this.status = NORMAL;
    }

    @Override
    public void onTouchDragged(float x, float y) {
        //开始拖动时，设置状态为拖动
        this.status = TOUCH_DRAGGED;
        if (this.hasListener()) {
            this.cardViewListener.onDragged(this, x, y);
        }
        this.pointX = x;
        this.pointY = y;
    }

    @Override
    public boolean isXYinMe(float x, float y) {
        return this.meView.getBoundingRectangle().contains(x, y);
    }

    /**
     * 判断是否是被拖动的状态
     *
     * @return
     */
    private boolean isDragged() {
        return this.status == TOUCH_DRAGGED;
    }

    /**
     * 判断是否是被按下的状态
     *
     * @return
     */
    private boolean isTouchDown() {
        return this.status == TOUCH_DOWN;
    }

    public void disableClick() {
        this.enableClick = false;
    }

    public void enableClick() {
        this.enableClick = true;
    }

    public void disableDrag() {
        this.enableDrag = false;
    }

    public void enableDrag() {
        this.enableDrag = true;
    }

}
