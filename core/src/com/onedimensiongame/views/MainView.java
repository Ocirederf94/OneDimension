package com.onedimensiongame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.onedimensiongame.gameobjects.CoverBlock;
import com.onedimensiongame.gameobjects.GuessButtons;
import com.onedimensiongame.gameobjects.GuessObject;
import com.badlogic.gdx.graphics.Color;
import com.onedimensiongame.utils.GameConstants;

import static com.onedimensiongame.utils.GameConstants.RETRY_BUTTON;
import static com.onedimensiongame.utils.GameConstants.GAP_SIZE;
import static com.onedimensiongame.utils.GameConstants.GUESS_BUTTON_SIZE;

/**
 * Created by fredy on 01/11/2017.
 */

public class MainView {
    private GuessObject guessObject;
    private CoverBlock topBlock, bottomBlock;
    private GuessButtons retryButton;
    private InputMultiplexer inputMultiplexer;


    ShapeRenderer shapeRenderer;


    public MainView() {
        guessObject = new GuessObject();
        topBlock = new CoverBlock(0, (Gdx.graphics.getHeight()/ 2)+ (GAP_SIZE / 2));
        bottomBlock = new CoverBlock(0,0);
        retryButton = new GuessButtons(guessObject, RETRY_BUTTON, 0, Gdx.graphics.getHeight() - GUESS_BUTTON_SIZE, GUESS_BUTTON_SIZE, GUESS_BUTTON_SIZE - (GUESS_BUTTON_SIZE / 4 ));
        inputMultiplexer = new InputMultiplexer();
        addInputProcessor(retryButton.getInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);


    }

    public void renderMainView() {
        /*
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/

     Gdx.gl.glClearColor(1, 0, 0, 1);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

       // Sprite s=new Sprite(tex);
        float alpha=0.5f; //or whatever you want
       // s.draw(batch,alpha);

        topBlock.renderGuessObject();
        bottomBlock.renderGuessObject();
        guessObject.renderGuessObject();
        guessObject.showKeyBoard();


        retryButton.renderButton();

       // shapeRenderer.end();

    }

    public void disposeMainView() {
        guessObject.disposeGuessObject();
        topBlock.disposeGuessObject();
        bottomBlock.disposeGuessObject();
        retryButton.disposeGuessButtons();
    }

    private void addInputProcessor(InputProcessor... inputProcessors){
        for (InputProcessor element: inputProcessors){
            inputMultiplexer.addProcessor(element);
        }
    }

}
