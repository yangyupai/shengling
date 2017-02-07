package com.yangyupai.game.datas;

import com.yangyupai.game.models.Card;
import com.yangyupai.game.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dongwenqiang on 16/12/4.
 */
public class Cards {

    private static List<String> initData;

    static {
        initData = new ArrayList<String>() {{
            add("1001,xiaoming,badlogic.jpg,10,5,9002");
            add("1002,xiaohong,badlogic.jpg,5,8,9001");
            add("1003,xiaogang,badlogic.jpg,20,2,9002");
            add("1004,xiaojun,badlogic.jpg,7,7,9001");
            add("1005,xiaoqiang,badlogic.jpg,1,1,9002");
            add("1006,xiaoliang,badlogic.jpg,2,2,9002");
            add("1007,xiaowang,badlogic.jpg,4,5,9002");
            add("1008,xiaozhao,badlogic.jpg,7,8,9002");
            add("1009,xiaoma,badlogic.jpg,2,10,9002");
            add("1010,xiaozhang,badlogic.jpg,30,15,9002");
        }};
    }

    public static List<Card> getAllCardData() {
        List<Card> cards = new ArrayList<Card>();
        for (String cardStr : initData) {
            String[] cardInfo = cardStr.split(",");
            String id = cardInfo[0];
            String name = cardInfo[1];
            String bg = cardInfo[2];
            int hp = Integer.parseInt(cardInfo[3]);
            int damage = Integer.parseInt(cardInfo[4]);
            String skillId = cardInfo[5];

            Card card = new Card();
            card.setId(id);
            card.setName(name);
            card.setBg(bg);
            card.setHp(hp);
            card.setDamage(damage);
            card.setExp(0);
            card.setLevel(1);
            card.setSkillId(skillId);

            cards.add(card);
        }
        return cards;
    }
}
