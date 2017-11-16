package com.onedimensiongame.utils;

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

/**
 * Created by fredy on 15/11/2017.
 */

public class CustomKeyboard {
    private BitmapFont bitmapFont;
    private float initialX, initialY, keysWidht, keysHeight;
    int counter = 0;
    private Stage stage;
    private InputProcessor inputProcessor;
    private SpriteBatch spriteBatch;
    private String guessString = "";

    public CustomKeyboard(float initialX, float initialY) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.keysWidht = Gdx.graphics.getWidth() / 10;
        this.keysHeight = (Gdx.graphics.getHeight() / 3) / 4;
        this.stage = new Stage();
        this.inputProcessor = stage;
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        createKeyboard();
        stage.act(Gdx.graphics.getDeltaTime());
    }

    public void renderKeyboard() {
        stage.draw();
        createTextField(counter);
    }

    public void disposeKeyboard() {
        stage.dispose();
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }

    private void createKeyboard() {
        KeyboardKeys[] keysArray = KeyboardKeys.values();
        ChangeListener changeListener = startKeyListener();
        int keysArrayIndex = 0;
        while (counter != keysHeight * 4) {
            for (int i = 0; i < 10; i++) {
                ImageButton tempImageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(keysArray[keysArrayIndex].getImagePath()))));
                tempImageButton.setName(keysArray[keysArrayIndex].getText());
                tempImageButton.setPosition(keysWidht * i, initialY + counter);
                tempImageButton.setSize(keysWidht, keysWidht);
                stage.addActor(tempImageButton);
                tempImageButton.addListener(changeListener);
                keysArrayIndex++;
            }
            counter += keysHeight;
        }
    }

    private void createTextField(float counter){
        spriteBatch.begin();
        bitmapFont.setColor(Color.YELLOW);
        bitmapFont.draw(spriteBatch, guessString, 0, counter + keysHeight);
        bitmapFont.getData().setScale(10);
        spriteBatch.end();
    }
    
    private ChangeListener startKeyListener(){
      return new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                guessString += actor.getName();
            }
        };
    }
}
