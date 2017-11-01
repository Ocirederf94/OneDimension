package com.onedimensiongame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.onedimensiongame.gameobjects.GuessObject;

/**
 * Created by fredy on 01/11/2017.
 */

public class MainView {
    private GuessObject guessObject;

    public MainView() {
        guessObject = new GuessObject();
    }

    public void renderMainView() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guessObject.renderGuessObject();
        guessObject.moveGuessObject();
    }

    public void disposeMainView() {
        guessObject.disposeGuessObject();
    }

}
