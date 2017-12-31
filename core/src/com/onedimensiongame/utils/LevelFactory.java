package com.onedimensiongame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.gameobjects.GuessButtons;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.onedimensiongame.utils.GameConstants.FEEDBACK_TIME;
import static com.onedimensiongame.utils.GameConstants.RIGHT_FEEDBACK;
import static com.onedimensiongame.utils.GameConstants.WRONG_FEEDBACK;

/**
 * Created by fredy on 26/11/2017.
 */

public class LevelFactory {
    private List<LevelsEnum> levelsEnumArrayList;
    private Random rand;
    private Texture levelCleared;
    private Texture levelFailed;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private Timer timer;

    public LevelFactory() {
        this.levelsEnumArrayList = Arrays.asList(LevelsEnum.values());
        this.timer = new Timer();
        this.rand = new Random();
        this.levelCleared = new Texture(RIGHT_FEEDBACK);
        this.levelFailed = new Texture(WRONG_FEEDBACK);
        this.spriteBatch = new SpriteBatch();
        this.sprite = new Sprite();
        this.sprite.setSize(200, 200);
        this.sprite.setPosition(Gdx.graphics.getWidth() - (levelCleared.getWidth() / 2), Gdx.graphics.getHeight() - (levelCleared.getHeight() / 2));
    }

    public LevelsEnum getRandomLevel() {
        return levelsEnumArrayList.get(rand.nextInt(levelsEnumArrayList.size()));
    }

    public void rederLevelFeedBack(final GuessButtons guessButton) {
        if (guessButton.getToRender()) {
            sprite.setTexture(guessButton.getRightAnswer() ? levelCleared : levelFailed);
            spriteBatch.begin();
            sprite.draw(spriteBatch);
            spriteBatch.end();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    guessButton.setToRender(false);
                }
            }, FEEDBACK_TIME);
        }
    }

    public void disposeLevelFactory() {
        spriteBatch.dispose();
    }

}
