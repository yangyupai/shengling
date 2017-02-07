package com.yangyupai.game.skills;

import com.yangyupai.game.models.Card;

/**
 * Created by dongwenqiang on 17/2/7.
 */
public abstract class Skill {

    protected Card owner;//技能拥有者

    public void setOwner(Card card) {
        this.owner = card;
    }

    public abstract void handle(Card... cards);
    public abstract String getSkillName();
    public abstract String getSkillDescription();
}
