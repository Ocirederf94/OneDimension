package com.onedimensiongame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by fredy on 26/11/2017.
 */

public class LevelFactory {
    private List<LevelsEnum> levelsEnumArrayList;
    private Random rand;

    public LevelFactory(){
        levelsEnumArrayList = Arrays.asList(LevelsEnum.values());
        rand = new Random();
    }

    public LevelsEnum getRandomLevel(){
        return levelsEnumArrayList.get(rand.nextInt(levelsEnumArrayList.size()));
    }

}
