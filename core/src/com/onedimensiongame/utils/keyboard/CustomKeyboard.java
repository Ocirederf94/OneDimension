package com.onedimensiongame.utils.keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.onedimensiongame.gameobjects.GuessObject;
import com.onedimensiongame.utils.levels.LevelFactory;

import static com.onedimensiongame.utils.GameConstants.DELETE;
import static com.onedimensiongame.utils.GameConstants.EXPERIMENTAL_KEY;
import static com.onedimensiongame.utils.GameConstants.SUBMIT;

/**
 * Created by fredy on 15/11/2017.
 */

public class CustomKeyboard {
    private BitmapFont bitmapFont;
    private float keysWidht, keysHeight;
    private Stage stage;
    private InputProcessor inputProcessor;
    private SpriteBatch spriteBatch;
    private String guessString = "";
    private GuessObject guessObject;
    private LevelFactory levelFactory;
    private float counter = 0;

    public CustomKeyboard(GuessObject guessObject, LevelFactory levelFactory) {
        this.guessObject = guessObject;
        this.keysWidht = (Gdx.graphics.getWidth() / 10);
        this.keysHeight = (((Gdx.graphics.getHeight() / 2) / 2) / 4);
        this.stage = new Stage();
        this.inputProcessor = stage;
        this.levelFactory = levelFactory;
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.YELLOW);
        bitmapFont.getData().setScale(10);
        createKeyboard();
        stage.act(Gdx.graphics.getDeltaTime());

    }

    public void renderKeyboard() {
        if (guessObject.getSprite().getY() < (Gdx.graphics.getHeight() / 4) && !levelFactory.getIsShowSolution()) {
            stage.draw();
            createTextField(counter);
        } else {
            guessString = "";
        }
    }

    public void disposeKeyboard() {
        stage.dispose();
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }


    public String getGuessString() {
        return guessString;
    }

    private void createKeyboard() {
        KeyboardKeysEnum[] keysArray = KeyboardKeysEnum.values();
        ChangeListener changeListener = startKeyListener();
        int keysArrayIndex = 0;
        while (counter < 4) {
            for (int i = 0; i < 10; i++) {
                //ImageButton tempImageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(keysArray[keysArrayIndex].getImagePath()))));
                ImageButton tempImageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(EXPERIMENTAL_KEY))));
                tempImageButton.setName(keysArray[keysArrayIndex].getText());
                tempImageButton.setBounds(keysWidht * i, keysHeight * counter, keysWidht, keysHeight);
                tempImageButton.getImage().setFillParent(true);
                stage.addActor(tempImageButton);
                tempImageButton.addListener(changeListener);
                keysArrayIndex++;
                Gdx.app.log(String.valueOf(tempImageButton.getWidth()) + " " + String.valueOf(tempImageButton.getHeight()) + "Position", String.valueOf(tempImageButton.getX()) + " " + String.valueOf(tempImageButton.getY()));
            }
            counter++;
        }
    }

    private void createTextField(float counter) {
        spriteBatch.begin();
        bitmapFont.draw(spriteBatch, guessString, 0, (counter + 2) * keysHeight);
        spriteBatch.end();
    }

    private ChangeListener startKeyListener() {
        return new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!actor.getName().equals(SUBMIT)) {
                    guessString = actor.getName().equals(DELETE) ? guessString.equals("") ? "" : guessString.substring(0, guessString.length() - 1)
                            : guessString.concat(actor.getName());
                } else {
                    if (guessString.equals(guessObject.getSolution())) {
                        return;
                    }
                }
            }
        };
    }
}
