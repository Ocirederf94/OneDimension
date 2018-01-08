package com.onedimensiongame.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.utils.levels.LevelFactory;

import static com.onedimensiongame.utils.GameConstants.OPAQUE_IMAGE;

/**
 * Created by fabian.sanchez on 03/11/2017.
 */

public class CoverBlock extends GameObject {
    private LevelFactory levelFactory;

    public CoverBlock(LevelFactory levelFactory, int positionX, int positionY) {
        super(new Texture(OPAQUE_IMAGE), positionX, positionY, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight() / 2));
        this.levelFactory = levelFactory;
    }

    @Override
    public void drawSprite(Sprite sprite,SpriteBatch spriteBatch) {
        float opacity = levelFactory.getIsShowSolution()? 0.5f: 999999999f;
       sprite.draw(spriteBatch, opacity);
    }

}
