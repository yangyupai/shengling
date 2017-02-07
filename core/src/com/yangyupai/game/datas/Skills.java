package com.yangyupai.game.datas;

import com.yangyupai.game.skills.KillOne;
import com.yangyupai.game.skills.Skill;
import com.yangyupai.game.skills.TreatMe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dongwenqiang on 17/2/7.
 */
public class Skills {
    private static Map<String, Class<?>> initData;

    static {
        initData = new HashMap<String, Class<?>>() {{
            put("9001", KillOne.class);
            put("9002", TreatMe.class);
        }};
    }

    public static Skill getSkill(String id) {
        if (initData.containsKey(id)) {
            Class cls = initData.get(id);
            try {
                return (Skill) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
