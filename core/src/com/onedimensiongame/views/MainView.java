package com.onedimensiongame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.onedimensiongame.gameobjects.CoverBlock;
import com.onedimensiongame.gameobjects.GuessObject;
import com.onedimensiongame.utils.GameConstants;

/**
 * Created by fredy on 01/11/2017.
 */

public class MainView {
    private GuessObject guessObject;
    private CoverBlock topBlock;
    private CoverBlock bottomBlock;
    private ShapeRenderer shapeRenderer= new ShapeRenderer();

    public MainView() {
        guessObject = new GuessObject();
        topBlock = new CoverBlock(0,  (Gdx.graphics.getHeight()/ 2)+ GameConstants.GAP_SIZE);

        bottomBlock = new CoverBlock(0,0);
    }

    public void renderMainView() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        guessObject.renderGuessObject();
        guessObject.moveGuessObject();
        topBlock.drawCoverBlock();
        bottomBlock.drawCoverBlock();
    }

    public void disposeMainView() {
        guessObject.disposeGuessObject();
    }

}
