package com.yangyupai.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by dongwenqiang on 16/11/13.
 */
public class Card {

    private String id;//卡牌ID
    private String bg;//卡牌背景图
    private String name;//卡牌名称
    private int hp;//卡牌生命值
    private int damage;//卡牌伤害值
    private int level;//卡牌等级
    private int exp;//卡牌经验值

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * 升级方法的例子
     *
     * @param exp
     */
    public void addExp(int exp) {
        this.exp = this.exp + exp;
        if (this.exp > 100) {
            this.level = this.level + 1;
            this.hp = this.hp + 1;
            this.damage = this.damage + 1;
            this.exp = this.exp - 100;
        }
    }

    /**
     * 保存卡牌数据
     */
    public void save() {
        Preferences preferences = Gdx.app.getPreferences(this.id);
        preferences.putString("name", this.getName());
        preferences.putString("bg", this.getBg());
        preferences.putInteger("hp", this.getHp());
        preferences.putInteger("damage", this.getDamage());
        preferences.putInteger("level", this.getLevel());
        preferences.putInteger("exp", this.getExp());
        preferences.flush();
    }

    /**
     * 读取卡牌
     *
     * @param id
     * @return
     */
    public static Card load(String id) {
        Preferences preferences = Gdx.app.getPreferences(id);
        Card card = new Card();
        card.setId(id);
        card.setBg(preferences.getString("bg"));
        card.setName(preferences.getString("name"));
        card.setHp(preferences.getInteger("hp"));
        card.setDamage(preferences.getInteger("damage"));
        card.setLevel(preferences.getInteger("level"));
        card.setExp(preferences.getInteger("exp"));
        System.out.println("Load card:" + card);
        return card;
    }

    @Override
    public String toString() {
        return "[ID]" + this.getId() + "[BG]" + this.getBg();
    }
}
