package com.yangyupai.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.yangyupai.game.datas.Skills;
import com.yangyupai.game.skills.Skill;

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
    private String skillId;//卡牌ID

    private Skill skill;//卡牌技能

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

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
        this.skill.setOwner(this);
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
        preferences.putString("skillId", this.getSkillId());
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
        String skillId = preferences.getString("skillId");
        Skill skill = Skills.getSkill(skillId);
        if (skill != null) {
            card.setSkill(skill);
            System.out.println(id + "加入技能" + skillId + " " + skill.getSkillName());
        } else {
            System.out.println(id + "技能" + skillId + "初始化失败");
        }
        System.out.println("Load card:" + card);
        return card;
    }

    public void beAttack(Card enemy) {
        int enemyDamage = enemy.getDamage();
        this.setHp(this.getHp() - enemyDamage);
    }

    public void useSkillTo(Card... cards) {
        if (cards == null) {
            System.out.println("目标为空");
        } else {
            this.skill.handle(cards);
        }
    }

    @Override
    public String toString() {
        return "[ID]" + this.getId() + "[BG]" + this.getBg();
    }
}
