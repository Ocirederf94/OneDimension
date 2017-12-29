package com.onedimensiongame.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.onedimensiongame.utils.GameConstants.OPAQUE_IMAGE;

/**
 * Created by fabian.sanchez on 03/11/2017.
 */

public class CoverBlock extends GameObject {

    public CoverBlock(int positionX, int positionY) {
        super(new Texture(OPAQUE_IMAGE), positionX, positionY, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight() / 2));
    }

    @Override
    public void drawSprite(Sprite sprite,SpriteBatch spriteBatch) {
       sprite.draw(spriteBatch,0.5f);
    }

}
