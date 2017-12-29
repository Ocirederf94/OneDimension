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
    private Texture texture;


    public GameObject(Texture texture, float x, float y, float width, float height){
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setColor(Color.RED);
        this.sprite.setSize(width, height);
        this.sprite.setPosition(x, y);
        this.spriteBatch = new SpriteBatch();
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
