package com.yangyupai.game.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongwenqiang on 16/12/4.
 */
public class User {

    List<String> allMyCardIds = new ArrayList<String>();

    List<Card> allMyCards = new ArrayList<Card>();

    public User() {
        this.allMyCardIds.add("1001");
        this.allMyCardIds.add("1003");
        this.allMyCardIds.add("1004");
        this.allMyCardIds.add("1005");
        this.allMyCardIds.add("1007");
    }

    public void init() {
        for (String id : allMyCardIds) {
            this.allMyCards.add(Card.load(id));
        }
    }

    public List<Card> getAllMyCards() {
        return this.allMyCards;
    }
}
