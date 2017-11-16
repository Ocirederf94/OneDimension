package com.onedimensiongame.utils;

import static com.onedimensiongame.utils.GameConstants.LETTER_A;
import static com.onedimensiongame.utils.GameConstants.RETRY_BUTTON;

/**
 * Created by fredy on 16/11/2017.
 */

public enum KeyboardKeys {
    ZZ(LETTER_A, "Z"),
    XX(RETRY_BUTTON, "X"),
    CC(LETTER_A, "C"),
    VV(LETTER_A, "V"),
    BB(LETTER_A, "B"),
    NN(LETTER_A, "N"),
    MM(LETTER_A, "M"),
    SPACE(LETTER_A, " "),
    BACKSPACE(LETTER_A, ""),
    ENTER(LETTER_A, "\n"),

    AA(LETTER_A, "A"),
    SS(LETTER_A, "S"),
    DD(LETTER_A, "D"),
    FF(LETTER_A, "F"),
    GG(LETTER_A, "G"),
    HH(LETTER_A, "H"),
    JJ(LETTER_A, "J"),
    KK(LETTER_A, "K"),
    LL(LETTER_A, "L"),
    ÇÇ(LETTER_A, "Ç"),

    QQ(LETTER_A, "Q"),
    WW(LETTER_A, "W"),
    EE(LETTER_A, "E"),
    RR(LETTER_A, "R"),
    TT(LETTER_A, "T"),
    YY(LETTER_A, "Y"),
    UU(LETTER_A, "U"),
    II(LETTER_A, "I"),
    OO(LETTER_A, "O"),
    PP(LETTER_A, "P"),

    ONE(LETTER_A, "1"),
    TWO(LETTER_A, "2"),
    THREE(LETTER_A, "3"),
    FOR(LETTER_A, "4"),
    FIVE(LETTER_A, "5"),
    SIX(LETTER_A, "6"),
    SEVEN(LETTER_A, "7"),
    EIGHT(LETTER_A, "8"),
    NINE(LETTER_A, "9"),
    ZERO(RETRY_BUTTON, "0");


    private String imagePath;
    private String text;

    KeyboardKeys(String imagePath, String text) {
        this.imagePath = imagePath;
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getText(){
        return text;
    }
}
