package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_MOVE_SPEED;
import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;
import static com.onedimensiongame.utils.GameConstants.LETTER_A;

/**
 * Created by fabian.sanchez on 07/11/2017.
 */

public abstract class GameObject {


    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private float positionX, positionY;


    public GameObject(){
        sprite = new Sprite(getTexture());
        setSpriteSize(sprite);
        sprite.setColor(Color.BLACK);
        spriteBatch = new SpriteBatch();
        sprite.setPosition((positionX = getInitialX()), (positionY = getInitialY()));
    }

    public abstract Texture getTexture();
    public abstract void setSpriteSize(Sprite sprite);

    public void renderGuessObject(){
        spriteBatch.begin();
        //sprite.draw(spriteBatch,0.5f);
        drawSprite(sprite,spriteBatch);
        spriteBatch.end();
    }

    public abstract void drawSprite(Sprite sprite, SpriteBatch spriteBatch);

    public void disposeGuessObject(){
        //texture.dispose();
        spriteBatch.dispose();
    }

    public abstract float getInitialX();
    public abstract float getInitialY();

    public float getPositionX() {

        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}
