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
    }

    public void disposeGuessObject(){
        texture.dispose();
        spriteBatch.dispose();
    }

    public void moveGuessObject(){
        sprite.translateY(-GUESS_OBJECT_MOVE_SPEED);
    }

    private void startGuessObject(){
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    private float setInitialX(){
        return (Gdx.graphics.getWidth() / 2) - (GUESS_OBJECT_SPRITE_SIZE / 2);
    }
    private float setInitialY(){
        return (Gdx.graphics.getHeight() - GUESS_OBJECT_SPRITE_SIZE);
    }
}