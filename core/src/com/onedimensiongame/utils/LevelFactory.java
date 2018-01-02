package com.onedimensiongame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.gameobjects.GuessButtons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
    private Random rand;
    private Texture levelCleared;
    private Texture levelFailed;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private Timer timer;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Map<String, String> guessObjectsMap;

    public LevelFactory() {
        try {
            this.bufferedReader = new BufferedReader(new FileReader("files/OriginalLevels.txt"));
            this.bufferedWriter = new BufferedWriter(new FileWriter("files/ModifiedLevels.txt"));
            this.guessObjectsMap = new HashMap<String, String>();
            getLevelsFromFile();

            this.timer = new Timer();
            this.rand = new Random();

            this.levelCleared = new Texture(RIGHT_FEEDBACK);
            this.levelFailed = new Texture(WRONG_FEEDBACK);

            this.spriteBatch = new SpriteBatch();
            this.sprite = new Sprite();
            this.sprite.setSize(200, 200);
            this.sprite.setPosition(Gdx.graphics.getWidth() - (levelCleared.getWidth() / 2), Gdx.graphics.getHeight() - (levelCleared.getHeight() / 2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void renderLevelFeedBack(final GuessButtons guessButton) {
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

    public String getRandomLevel() {
        String[] tempArray = (String[]) guessObjectsMap.keySet().toArray();
        String key = tempArray[rand.nextInt(tempArray.length - 1)];
        return key + " " + guessObjectsMap.get(key);
    }

    private void getLevelsFromFile() {
        String tempString;
        try {
            while ((tempString = bufferedReader.readLine()) != null) {
                String path = tempString.substring(0, tempString.indexOf(" "));
                String solution = tempString.substring(tempString.indexOf(" "), tempString.length());
                guessObjectsMap.put(path, solution);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
