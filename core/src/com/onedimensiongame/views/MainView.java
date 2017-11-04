package com.onedimensiongame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.onedimensiongame.gameobjects.CoverBlock;
import com.onedimensiongame.gameobjects.GuessButtons;
import com.onedimensiongame.gameobjects.GuessObject;
import static com.onedimensiongame.utils.GameConstants.RETRY_BUTTON;
import static com.onedimensiongame.utils.GameConstants.GAP_SIZE;
import static com.onedimensiongame.utils.GameConstants.GUESS_BUTTON_SIZE;

/**
 * Created by fredy on 01/11/2017.
 */

public class MainView {
    private GuessObject guessObject;
    private CoverBlock topBlock;
    private CoverBlock bottomBlock;
    private GuessButtons retryButton;
    private InputMultiplexer inputMultiplexer;


    public MainView() {
        guessObject = new GuessObject();
        topBlock = new CoverBlock(0,  (Gdx.graphics.getHeight()/ 2)+ (GAP_SIZE / 2));
        bottomBlock = new CoverBlock(0,0);
        retryButton = new GuessButtons(guessObject, RETRY_BUTTON, 0, Gdx.graphics.getHeight() - GUESS_BUTTON_SIZE, GUESS_BUTTON_SIZE, GUESS_BUTTON_SIZE - (GUESS_BUTTON_SIZE / 4 ));
        inputMultiplexer = new InputMultiplexer();
        addInputProcessor(retryButton.getInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void renderMainView() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        guessObject.renderGuessObject();
        guessObject.showKeyBoard();
        topBlock.drawCoverBlock();
        bottomBlock.drawCoverBlock();
        retryButton.renderButton();
    }

    public void disposeMainView() {
        guessObject.disposeGuessObject();
        topBlock.disposeCoverBlock();
        bottomBlock.disposeCoverBlock();
        retryButton.disposeGuessButtons();
    }

    private void addInputProcessor(InputProcessor... inputProcessors){
        for (InputProcessor element: inputProcessors){
            inputMultiplexer.addProcessor(element);
        }
    }

}
