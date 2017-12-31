package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.onedimensiongame.utils.CustomKeyboard;
import com.onedimensiongame.utils.LevelFactory;
import com.onedimensiongame.utils.LevelsEnum;

import java.util.Timer;
import java.util.TimerTask;

import static com.onedimensiongame.utils.GameConstants.FEEDBACK_TIME;
import static com.onedimensiongame.utils.GameConstants.GUESS_BUTTON_SIZE;
import static com.onedimensiongame.utils.GameConstants.RETRY;
import static com.onedimensiongame.utils.GameConstants.SUBMIT;

/**
 * Created by fredy on 04/11/2017.
 */

public class GuessButtons extends ImageButton {
    private GuessObject guessObject;
    private Stage stage;
    private InputProcessor inputProcessor;
    private String buttonId;
    private CustomKeyboard customKeyboard;
    private LevelFactory levelFactory;
    private boolean toRender = false;
    private boolean rightAnswer = false;
    private Timer timer;


    public GuessButtons(GuessObject guessObject, LevelFactory levelFactory, String buttonId, String texturePath, float x, float y, CustomKeyboard customKeyboard) {
        super(new TextureRegionDrawable(new TextureRegion(new Texture(texturePath))));
        this.timer = new Timer();
        this.customKeyboard = customKeyboard;
        this.levelFactory = levelFactory;
        this.buttonId = buttonId;
        this.guessObject = guessObject;
        this.setX(x);
        this.setY(y);
        this.setWidth(GUESS_BUTTON_SIZE);
        this.setHeight(GUESS_BUTTON_SIZE - (GUESS_BUTTON_SIZE / 4));
        stage = new Stage();
        inputProcessor = stage;
        stage.addActor(this);
        stage.act(Gdx.graphics.getDeltaTime());
        addCustomListener();
    }

    public void renderButton() {
        stage.draw();
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }

    public void disposeGuessButtons() {
        stage.dispose();
    }

    public boolean getToRender() {
        return toRender;
    }

    public void setToRender(boolean toRender) {
        this.toRender = toRender;
    }

    public boolean getRightAnswer() {
        return rightAnswer;
    }

    private void addCustomListener() {
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                LevelsEnum levelsEnum;
                if (buttonId.equals(RETRY)) {
                    guessObject.resetGuessObjectPosition();
                    Gdx.input.setOnscreenKeyboardVisible(false);
                } else if (buttonId.equals(SUBMIT)) {
                    if (customKeyboard.getGuessString().toUpperCase().equals(guessObject.getSolution())) {
                        toRender = true;
                        rightAnswer = true;
                        setTimer();

                        levelsEnum = levelFactory.getRandomLevel();
                        guessObject.setSolution(levelsEnum.getSolution());
                        guessObject.setTexture(levelsEnum.getImagePath());

                    } else {
                        toRender = true;
                        rightAnswer = false;
                        setTimer();
                    }
                }
            }
        });
    }

    private void setTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                guessObject.resetGuessObjectPosition();
            }
        }, FEEDBACK_TIME);
    }


}
