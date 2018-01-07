package com.onedimensiongame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.utils.levels.LevelFactory;

import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_MOVE_SPEED;
import static com.onedimensiongame.utils.GameConstants.GUESS_OBJECT_SPRITE_SIZE;
import static com.onedimensiongame.utils.GameConstants.LETTER_A;


/**
 * Created by fredy on 01/11/2017.
 */

public class GuessObject extends GameObject {
    private  static String solution;
    private static String path;

    public GuessObject(boolean isResume, LevelFactory levelFactory, float positionX, float positionY) {
        super(new Texture(isResume ? subStringToPath(levelFactory.getRandomLevel()) : LETTER_A), positionX, positionY, GUESS_OBJECT_SPRITE_SIZE, GUESS_OBJECT_SPRITE_SIZE);
        if(!isResume) solution = "A";
    }

    @Override
    public void drawSprite(Sprite sprite, SpriteBatch spriteBatch) {
        this.sprite.draw(spriteBatch);
    }

    public String getSolution(){
        return solution;
    }

    public String getPath(){
        return path;
    }

    public void setSolution(String newSolution){
        solution = newSolution;
    }

    public void moveGuessObject() {
        this.sprite.translateY(-GUESS_OBJECT_MOVE_SPEED);
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setTexture(String path){
        this.sprite.setTexture(new Texture(path));
    }

    public void resetGuessObjectPosition() {
        this.sprite.setPosition(setInitialX(), setInitialY());
    }

    private float setInitialX() {
        return (Gdx.graphics.getWidth() / 2) - (GUESS_OBJECT_SPRITE_SIZE / 2);
    }

    private float setInitialY() {
        return (Gdx.graphics.getHeight() - GUESS_OBJECT_SPRITE_SIZE);
    }


    private static String subStringToPath(String completeString){
        solution = completeString.substring(completeString.indexOf(" ") + 1, completeString.length());
        return path = completeString.substring(0, completeString.indexOf(" "));
    }

}
