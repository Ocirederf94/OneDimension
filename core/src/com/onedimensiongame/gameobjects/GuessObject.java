package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_MOVE_SPEED;
import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;
import static com.onedimensiongame.utils.GameConstants.LETTER_A;


/**
 * Created by fredy on 01/11/2017.
 */

public class GuessObject extends GameObject {

    public GuessObject(float positionX, float positionY) {
        super(new Texture(LETTER_A), positionX, positionY, GUESS_OBJECT_SPRITE_SIZE, GUESS_OBJECT_SPRITE_SIZE);
    }

    @Override
    public void drawSprite(Sprite sprite, SpriteBatch spriteBatch) {
        this.sprite.draw(spriteBatch);
    }

    public String getSolution(){
        return "";
    }

    public void moveGuessObject() {
        this.sprite.translateY(-GUESS_OBJECT_MOVE_SPEED);
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void resetGuessObjectPosition() {
        this.sprite.setPosition(setInitialX(), setInitialY());
    }

    private float setInitialX() {
        return (Gdx.graphics.getWidth() / 2) - (GUESS_OBJECT_SPRITE_SIZE / 2);
    }

    private float setInitialY() {
        return (Gdx.graphics.getHeight() - GUESS_OBJECT_SPRITE_SIZE);
    }

}
