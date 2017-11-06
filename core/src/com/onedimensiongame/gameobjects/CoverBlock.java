package com.onedimensiongame.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.onedimensiongame.utils.GameConstants;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by fabian.sanchez on 03/11/2017.
 */

public class CoverBlock extends GameObject {
    private float x, y;

    @Override
    public Texture getTexture() {
        return  new Texture("blocks/opaque.png");
    }

    @Override
    public void setSpriteSize(Sprite sprite) {
        sprite.setSize( Gdx.graphics.getWidth(),(Gdx.graphics.getHeight() / 2) - (GameConstants.GAP_SIZE / 2));
    }

    @Override
    public void drawSprite(Sprite sprite,SpriteBatch spriteBatch) {
       sprite.draw(spriteBatch,0.5f);
    }

    @Override
    public float getInitialX() {
        return x;
    }

    @Override
    public float getInitialY() {
        return y;
    }

    public CoverBlock(float x, float y) {
        super();
        this.x = x;
        this.y = y;
    }




}
