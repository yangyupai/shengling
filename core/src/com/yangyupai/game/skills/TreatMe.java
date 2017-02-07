package com.yangyupai.game.skills;

import com.yangyupai.game.models.Card;

/**
 * Created by dongwenqiang on 17/2/7.
 */
public class TreatMe extends Skill {

    @Override
    public void handle(Card... cards) {
        int currentHp = this.owner.getHp();
        this.owner.setHp(currentHp + 2);//为技能使用者增加2点生命
    }

    @Override
    public String getSkillName() {
        return "治疗自己";
    }

    @Override
    public String getSkillDescription() {
        return "增加自身两点生命值";
    }
}
