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

import static com.onedimensiongame.utils.GameConstants.RETRY_BUTTON;

/**
 * Created by fredy on 04/11/2017.
 */

public class GuessButtons extends ImageButton {
    private GuessObject guessObject;
    private Stage stage;
    private InputProcessor inputProcessor;
    private String texturePath;


    public GuessButtons(GuessObject guessObject, String texturePath, float x, float y, float width, float height) {
        super(new TextureRegionDrawable(new TextureRegion(new Texture(texturePath))));
        this.texturePath = texturePath;
        this.guessObject = guessObject;
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
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

    private void addCustomListener() {
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (texturePath.equals(RETRY_BUTTON)) {
                    guessObject.resetGuessObjectPosition();
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
            }
        });
    }
}
