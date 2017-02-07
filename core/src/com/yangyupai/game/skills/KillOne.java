package com.yangyupai.game.skills;

import com.yangyupai.game.models.Card;

/**
 * Created by dongwenqiang on 17/2/7.
 */
public class KillOne extends Skill {

    @Override
    public void handle(Card... cards) {
        for (Card c : cards) {
            c.setHp(0);//直接杀死目标卡牌
        }
    }

    @Override
    public String getSkillName() {
        return "命运之轮";
    }

    @Override
    public String getSkillDescription() {
        return "直接杀死一张卡牌";
    }
}
