package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by fabian.sanchez on 07/11/2017.
 */

public abstract class GameObject {
    protected SpriteBatch spriteBatch;
    protected Sprite sprite;


    public GameObject(Texture texture, int x, int y, int width, int height){
        sprite = new Sprite(texture, x, y, width, height);
//        sprite.setColor(Color.BLACK);
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
