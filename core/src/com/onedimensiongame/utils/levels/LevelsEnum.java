package com.onedimensiongame.utils.levels;

/**
 * Created by fredy on 30/12/2017.
 */

public class LevelsEnum {

    private String imagePath;
    private String solution;
    private int num;

    LevelsEnum(String imagePath, String solution, int num){
        this.imagePath = imagePath;
        this.solution = solution;
        this.num=num;
    }

    public String getImagePath() {
        return imagePath;
    }
    public int getNumber(){ return num;}
    public String getSolution() {
        return solution;
    }
}
