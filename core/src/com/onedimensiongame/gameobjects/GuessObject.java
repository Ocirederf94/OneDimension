package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.utils.levels.LevelFactory;
import com.onedimensiongame.utils.levels.LevelsEnum;

import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_MOVE_SPEED;
import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;



/**
 * Created by fredy on 01/11/2017.
 */

public class GuessObject extends GameObject {
    private static String solution, preTexture, preSolution, oldTextur;
    private LevelFactory levelFactory;
    private static LevelsEnum levelsEnum;

    public GuessObject(LevelFactory levelFactory, float positionX, float positionY) {
        super(new Texture((levelsEnum = levelFactory.getNextLevel()).getImagePath()), positionX, positionY, GUESS_OBJECT_SPRITE_SIZE, GUESS_OBJECT_SPRITE_SIZE);
        this.solution =  levelsEnum.getSolution();
        this.levelFactory = levelFactory;
    }

    @Override
    public void drawSprite(Sprite sprite, SpriteBatch spriteBatch) {
        this.sprite.draw(spriteBatch);
    }

    public String getSolution() {
        return solution;
    }

    public void moveGuessObject() {
        if (levelFactory.getIsShowSolution()) {
            if (this.sprite.getY() > 1) {
                this.sprite.translateY(-GUESS_OBJECT_MOVE_SPEED);
            } else {
                setSolution();
                setTexture();
                resetGuessObjectPosition();
                levelFactory.setIsShowSolution(false);
                if (levelFactory.getIsLastLevel()) Gdx.app.exit();
            }
        }
        if (this.sprite.getY() > 0) this.sprite.translateY(-GUESS_OBJECT_MOVE_SPEED);

    }

    public Sprite getSprite() {
        return sprite;
    }

    public void resetGuessObjectPosition() {
        this.sprite.setPosition(setInitialX(), setInitialY());
    }

    public void setPreTexture(String preTexture) {
        this.preTexture = preTexture;
    }

    public void setPreSolution(String preSolution) {
        this.preSolution = preSolution;
    }

    private void setSolution() {
        solution = preSolution;
    }

    private void setTexture() {
        oldTextur = preTexture;
        this.sprite.setTexture(new Texture(preTexture));
    }

    private float setInitialX() {
        return (Gdx.graphics.getWidth() / 2) - (GUESS_OBJECT_SPRITE_SIZE / 2);
    }

    private float setInitialY() {
        return (Gdx.graphics.getHeight() - GUESS_OBJECT_SPRITE_SIZE);
    }


}
