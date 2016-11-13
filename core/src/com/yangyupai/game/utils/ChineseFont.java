package com.yangyupai.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dongwenqiang on 16/10/1.
 */
public class ChineseFont {

    private static final String ttf = "fonts/siyuan.ttf";

    private Set<String> initWords = null;
    private Color color = null;
    private int fontsize = 0;

    public ChineseFont() {
        this.initWords = new HashSet<String>();
        this.color = Color.BLACK;
        this.fontsize = 14;
    }

    public ChineseFont addWords(String words) {
        for (char c : words.toCharArray()) {
            initWords.add(Character.toString(c));
        }
        return this;
    }

    public ChineseFont setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChineseFont setSize(int size) {
        this.fontsize = size;
        return this;
    }

    public BitmapFont generate() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(ttf));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = this.color;
        parameter.size = this.fontsize;
        parameter.characters = this.getInitWords();
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

    private String getInitWords() {
        StringBuffer sb = new StringBuffer();
        for (String s : this.initWords) {
            sb.append(s);
        }
        return sb.toString();
    }
}
