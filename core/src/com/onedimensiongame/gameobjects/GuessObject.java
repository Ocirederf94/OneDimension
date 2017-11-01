package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;
import static com.onedimensiongame.utils.GameConstants.LETTER_A;


/**
 * Created by fredy on 01/11/2017.
 */

public class GuessObject {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;

    public GuessObject(){
        texture = new Texture(LETTER_A);
        sprite = new Sprite(texture);
        sprite.setSize(GUESS_OBJECT_SPRITE_SIZE, GUESS_OBJECT_SPRITE_SIZE);
        sprite.setColor(Color.BLUE);
        spriteBatch = new SpriteBatch();
        sprite.setPosition(0,0);

    }

    private void startGuessObject(){
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    public void renderGuessObject(){
        startGuessObject();
    }

    public void disposeGuessObject(){
        texture.dispose();
        spriteBatch.dispose();
    }
}
