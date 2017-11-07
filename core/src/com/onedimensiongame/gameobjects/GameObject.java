package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by fabian.sanchez on 07/11/2017.
 */

public abstract class GameObject {
    protected SpriteBatch spriteBatch;
    protected Sprite sprite;


    public GameObject(Texture texture, float x, float y, float width, float height){
        sprite = new Sprite(texture);
        sprite.setColor(Color.RED);
        sprite.setSize(width, height);
        sprite.setPosition(x, y);
        spriteBatch = new SpriteBatch();
    }

    public void renderGameObject(){
        spriteBatch.begin();
        drawSprite(sprite,spriteBatch);
        spriteBatch.end();
    }

    public void disposeGuessObject(){
        spriteBatch.dispose();
    }

    public abstract void drawSprite(Sprite sprite, SpriteBatch spriteBatch);
}
