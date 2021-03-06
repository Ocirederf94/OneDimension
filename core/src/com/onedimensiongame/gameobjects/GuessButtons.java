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
import com.onedimensiongame.utils.keyboard.CustomKeyboard;
import com.onedimensiongame.utils.levels.LevelFactory;
import com.onedimensiongame.utils.levels.LevelsEnum;

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
    private LevelsEnum level;


    public GuessButtons(GuessObject guessObject, LevelFactory levelFactory, String buttonId, String texturePath, float x, float y, CustomKeyboard customKeyboard) {
        super(new TextureRegionDrawable(new TextureRegion(new Texture(texturePath))));
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
        if (buttonId.equals(RETRY)) stage.draw();
        else if (!customKeyboard.getGuessString().isEmpty()) stage.draw();
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
                if (buttonId.equals(RETRY)) {
                    guessObject.resetGuessObjectPosition();
                    Gdx.input.setOnscreenKeyboardVisible(false);
                } else if (buttonId.equals(SUBMIT) && !customKeyboard.getGuessString().isEmpty()) {
                    if (customKeyboard.getGuessString().toUpperCase().equals(guessObject.getSolution())) {

                        toRender = true;
                        rightAnswer = true;
                        guessObject.resetGuessObjectPosition();

                        levelFactory.setIsShowSolution(true);
                        if (!levelFactory.getIsLastLevel()) {
                            level = levelFactory.getNextLevel();
                            guessObject.setPreTexture(level.getImagePath());
                            guessObject.setPreSolution(level.getSolution());
                        }
                    } else {
                        levelFactory.setIsShowSolution(false);
                        toRender = true;
                        rightAnswer = false;
                        guessObject.resetGuessObjectPosition();
                    }
                }
            }
        });
    }

}
