package com.onedimensiongame.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.onedimensiongame.utils.GameConstants;

import static com.onedimensiongame.utils.GameConstants.GAP_SIZE;


/**
 * Created by fabian.sanchez on 03/11/2017.
 */

public class CoverBlock extends ShapeRenderer {
    private float x, y;

    public CoverBlock(float x, float y) {
        super();
        this.x = x;
        this.y = y;
    }

    public void drawCoverBlock() {
        this.setColor(Color.RED);
        this.begin(ShapeRenderer.ShapeType.Filled);
        this.rect(x, y, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight()/ 2) - (GameConstants.GAP_SIZE /2 ));
        this.end();
    }


}
