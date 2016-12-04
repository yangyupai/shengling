package com.yangyupai.game.interfaces;

import com.yangyupai.game.models.Card;
import com.yangyupai.game.views.CardView;

/**
 * Created by dongwenqiang on 16/12/4.
 */
public interface CardViewListener {

    public void onClick(CardView cardView);

    public void onDragged(CardView cardView, float x, float y);

    public void onDragFinish(CardView cardView);
}
