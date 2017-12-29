package com.onedimensiongame.utils;

import static com.onedimensiongame.utils.GameConstants.A_KEY;
import static com.onedimensiongame.utils.GameConstants.B_KEY;
import static com.onedimensiongame.utils.GameConstants.C_KEY;
import static com.onedimensiongame.utils.GameConstants.D_KEY;
import static com.onedimensiongame.utils.GameConstants.EIGHT_KEY;
import static com.onedimensiongame.utils.GameConstants.E_KEY;
import static com.onedimensiongame.utils.GameConstants.FIVE_KEY;
import static com.onedimensiongame.utils.GameConstants.FOUR_KEY;
import static com.onedimensiongame.utils.GameConstants.F_KEY;
import static com.onedimensiongame.utils.GameConstants.G_KEY;
import static com.onedimensiongame.utils.GameConstants.H_KEY;
import static com.onedimensiongame.utils.GameConstants.I_KEY;
import static com.onedimensiongame.utils.GameConstants.J_KEY;
import static com.onedimensiongame.utils.GameConstants.K_KEY;
import static com.onedimensiongame.utils.GameConstants.SPACE_KEY;
import static com.onedimensiongame.utils.GameConstants.L_KEY;
import static com.onedimensiongame.utils.GameConstants.M_KEY;
import static com.onedimensiongame.utils.GameConstants.NINE_KEY;
import static com.onedimensiongame.utils.GameConstants.N_KEY;
import static com.onedimensiongame.utils.GameConstants.ONE_KEY;
import static com.onedimensiongame.utils.GameConstants.O_KEY;
import static com.onedimensiongame.utils.GameConstants.P_KEY;
import static com.onedimensiongame.utils.GameConstants.Q_KEY;
import static com.onedimensiongame.utils.GameConstants.BACKSPACE_KEY;
import static com.onedimensiongame.utils.GameConstants.ENTER_KEY;
import static com.onedimensiongame.utils.GameConstants.DELETE;
import static com.onedimensiongame.utils.GameConstants.R_KEY;
import static com.onedimensiongame.utils.GameConstants.SEVEN_KEY;
import static com.onedimensiongame.utils.GameConstants.SIX_KEY;
import static com.onedimensiongame.utils.GameConstants.SUBMIT;
import static com.onedimensiongame.utils.GameConstants.S_KEY;
import static com.onedimensiongame.utils.GameConstants.THREE_KEY;
import static com.onedimensiongame.utils.GameConstants.TWO_KEY;
import static com.onedimensiongame.utils.GameConstants.T_KEY;
import static com.onedimensiongame.utils.GameConstants.U_KEY;
import static com.onedimensiongame.utils.GameConstants.V_KEY;
import static com.onedimensiongame.utils.GameConstants.W_KEY;
import static com.onedimensiongame.utils.GameConstants.X_KEY;
import static com.onedimensiongame.utils.GameConstants.Y_KEY;
import static com.onedimensiongame.utils.GameConstants.ZERO_KEY;
import static com.onedimensiongame.utils.GameConstants.Z_KEY;

/**
 * Created by fredy on 16/11/2017.
 */

public enum KeyboardKeysEnum {
    ZZ(Z_KEY, "Z"),
    XX(X_KEY, "X"),
    CC(C_KEY, "C"),
    VV(V_KEY, "V"),
    BB(B_KEY, "B"),
    NN(N_KEY, "N"),
    MM(M_KEY, "M"),
    SPACE(SPACE_KEY, " "),
    BACKSPACE(BACKSPACE_KEY, DELETE),
    ENTER(ENTER_KEY, SUBMIT),

    AA(A_KEY, "A"),
    SS(S_KEY, "S"),
    DD(D_KEY, "D"),
    FF(F_KEY, "F"),
    GG(G_KEY, "G"),
    HH(H_KEY, "H"),
    JJ(J_KEY, "J"),
    KK(K_KEY, "K"),
    LL(L_KEY, "L"),
    ÇÇ(ONE_KEY, "Ç"),

    QQ(Q_KEY, "Q"),
    WW(W_KEY, "W"),
    EE(E_KEY, "E"),
    RR(R_KEY, "R"),
    TT(T_KEY, "T"),
    YY(Y_KEY, "Y"),
    UU(U_KEY, "U"),
    II(I_KEY, "I"),
    OO(O_KEY, "O"),
    PP(P_KEY, "P"),

    ONE(ONE_KEY, "1"),
    TWO(TWO_KEY, "2"),
    THREE(THREE_KEY, "3"),
    FOR(FOUR_KEY, "4"),
    FIVE(FIVE_KEY, "5"),
    SIX(SIX_KEY, "6"),
    SEVEN(SEVEN_KEY, "7"),
    EIGHT(EIGHT_KEY, "8"),
    NINE(NINE_KEY, "9"),
    ZERO(ZERO_KEY, "0");


    private String imagePath;
    private String text;

    KeyboardKeysEnum(String imagePath, String text) {
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
