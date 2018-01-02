package com.onedimensiongame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.onedimensiongame.gameobjects.CoverBlock;
import com.onedimensiongame.gameobjects.GuessButtons;
import com.onedimensiongame.gameobjects.GuessObject;
import com.onedimensiongame.utils.CustomKeyboard;
import com.onedimensiongame.utils.LevelFactory;

import static com.onedimensiongame.utils.GameConstants.GAP_SIZE;
import static com.onedimensiongame.utils.GameConstants.GUESS_BUTTON_SIZE;
import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;
import static com.onedimensiongame.utils.GameConstants.RETRY_BUTTON;
import static com.onedimensiongame.utils.GameConstants.RETRY;
import static com.onedimensiongame.utils.GameConstants.SUBMIT;
import static com.onedimensiongame.utils.GameConstants.SUBMIT_BUTTON;


/**
 * Created by fredy on 01/11/2017.
 */

public class MainView {
    private GuessObject guessObject;
    private CoverBlock topBlock, bottomBlock;
    private GuessButtons retryButton;
    private GuessButtons submitButton;
    private CustomKeyboard customKeyboard;
    private InputMultiplexer inputMultiplexer;
    private LevelFactory levelFactory;

    public MainView() {
        guessObject = new GuessObject((Gdx.graphics.getWidth() / 2) - (GUESS_OBJECT_SPRITE_SIZE / 2), (Gdx.graphics.getHeight() - GUESS_OBJECT_SPRITE_SIZE));
        levelFactory = new LevelFactory();

        topBlock = new CoverBlock(0, Math.round((Gdx.graphics.getHeight()/ 2) + (GAP_SIZE / 2)));
        bottomBlock = new CoverBlock(0,0);

        customKeyboard = new CustomKeyboard(guessObject);

        retryButton = new GuessButtons(guessObject, levelFactory, RETRY, RETRY_BUTTON, 0, Gdx.graphics.getHeight() - GUESS_BUTTON_SIZE, customKeyboard);
        submitButton = new GuessButtons(guessObject, levelFactory, SUBMIT, SUBMIT_BUTTON, Gdx.graphics.getWidth() - GUESS_BUTTON_SIZE, Gdx.graphics.getHeight() - GUESS_BUTTON_SIZE, customKeyboard);

        inputMultiplexer = new InputMultiplexer();
        addInputProcessor(retryButton.getInputProcessor(), submitButton.getInputProcessor(), customKeyboard.getInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void renderMainView() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guessObject.renderGameObject();
        guessObject.moveGuessObject();

        topBlock.renderGameObject();
        bottomBlock.renderGameObject();

        customKeyboard.renderKeyboard();

        retryButton.renderButton();
        submitButton.renderButton();

        levelFactory.renderLevelFeedBack(submitButton);

    }

    public void disposeMainView() {
        guessObject.disposeGuessObject();
        topBlock.disposeGuessObject();
        bottomBlock.disposeGuessObject();
        retryButton.disposeGuessButtons();
        submitButton.disposeGuessButtons();
        customKeyboard.disposeKeyboard();
        levelFactory.disposeLevelFactory();
    }

    private void addInputProcessor(InputProcessor... inputProcessors){
        for (InputProcessor element: inputProcessors){
            inputMultiplexer.addProcessor(element);
        }
    }

}
