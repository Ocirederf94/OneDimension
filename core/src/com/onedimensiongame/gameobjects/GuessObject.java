package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;
import static com.onedimensiongame.utils.GameConstants.LETTER_A;
import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_MOVE_SPEED;


/**
 * Created by fredy on 01/11/2017.
 */

public class GuessObject {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private float positionX, positionY;


    public GuessObject(){
        texture = new Texture(LETTER_A);
        sprite = new Sprite(texture);
        sprite.setSize(GUESS_OBJECT_SPRITE_SIZE, GUESS_OBJECT_SPRITE_SIZE);
        sprite.setColor(Color.BLUE);
        spriteBatch = new SpriteBatch();
        sprite.setPosition((positionX = setInitialX()), (positionY = setInitialY()));


    }

    public void renderGuessObject(){
        startGuessObject();
        moveGuessObject();
    }

    public void showKeyBoard(){
        Gdx.input.setOnscreenKeyboardVisible( (sprite.getY() < Gdx.graphics.getHeight() / 4 ));
    }

    public void resetGuessObjectPosition(){
        sprite.setPosition(setInitialX(), setInitialY());
    }

    private void startGuessObject(){
        spriteBatch.begin();
        sprite.draw(spriteBatch,0.5f);
        spriteBatch.end();
    }

    private void moveGuessObject(){
        sprite.translateY(-GUESS_OBJECT_MOVE_SPEED);
    }

    public void disposeGuessObject(){
        texture.dispose();
        spriteBatch.dispose();
    }

    private float setInitialX(){
        return (Gdx.graphics.getWidth() / 2) - (GUESS_OBJECT_SPRITE_SIZE / 2);
    }
    private float setInitialY(){
        return (Gdx.graphics.getHeight() - GUESS_OBJECT_SPRITE_SIZE);
    }
}
