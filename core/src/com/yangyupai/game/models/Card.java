package com.yangyupai.game.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyupai.game.interfaces.ClickAble;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class Card implements ClickAble {

    private Sprite me;

    private String name = "";

    private OnClickListener listener;

    private int state = 0;

    public Card(Texture texture) {
        this.me = new Sprite(texture, 50, 50);
    }

    public void setPosition(float x, float y) {
        this.me.setPosition(x, y);
        this.me.getBoundingRectangle().setPosition(x, y);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void drawMe(SpriteBatch spriteBatch) {
        this.me.draw(spriteBatch);
    }

    @Override
    public void onTouchDown() {
        System.out.println("im touchdown:" + this.name);
    }

    @Override
    public void onTouchUp() {
        System.out.println("im touchedup:" + this.name);
        if (this.listener != null) {
            this.listener.onClick(this);
        }
    }

    @Override
    public void onTouchDragged() {

    }

    @Override
    public boolean isXYinMe(float x, float y) {
        return this.me.getBoundingRectangle().contains(x, y);
    }

    public interface OnClickListener {
        public void onClick(Card card);
    }
}
