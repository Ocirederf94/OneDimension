package com.onedimensiongame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.onedimensiongame.utils.GameConstants.LETTER_A;

/**
 * Created by fredy on 15/11/2017.
 */

public class CustomKeyboard {
    private float initialX, initialY, keysWidht, keysHeight;
    private Stage stage;
    private InputProcessor inputProcessor;

    public CustomKeyboard(float initialX, float initialY) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.keysWidht = Gdx.graphics.getWidth() / 10;
        this.keysHeight = (Gdx.graphics.getHeight() / 3) / 4;
        this.stage = new Stage();
        this.inputProcessor = stage;
        createKeyboard();
        stage.act(Gdx.graphics.getDeltaTime());
    }

    public void renderKeyboard() {
        stage.draw();
    }

    public void disposeKeyboard() {
        stage.dispose();
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }

    private void createKeyboard() {
        ChangeListener changeListener = startKeyListener();
        int counter = 0;
        while (counter != keysHeight * 5) {
            for (int i = 0; i < 10; i++) {
                float xPosition = keysWidht * i;
                ImageButton tempImageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(LETTER_A))));
                tempImageButton.setPosition(initialX + xPosition, initialY);
                tempImageButton.setSize(keysWidht, counter);
                stage.addActor(tempImageButton);
                tempImageButton.addListener(changeListener);
            }
            counter += keysHeight;
        }
    }

    private ChangeListener startKeyListener(){
      return new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        };
    }
}
