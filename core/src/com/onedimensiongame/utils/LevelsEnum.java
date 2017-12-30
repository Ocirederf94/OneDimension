package com.onedimensiongame.utils;

import static com.onedimensiongame.utils.GameConstants.LETTER_A;
import static com.onedimensiongame.utils.GameConstants.RETRY_BUTTON;

/**
 * Created by fredy on 30/12/2017.
 */

public enum LevelsEnum {
    WORD_A(LETTER_A, "A"),
    WORD_RETRY(RETRY_BUTTON, "RETRY");

    private String imagePath;
    private String solution;

    LevelsEnum(String imagePath, String solution){
        this.imagePath = imagePath;
        this.solution = solution;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getSolution() {
        return solution;
    }
}
