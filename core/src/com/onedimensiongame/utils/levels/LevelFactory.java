package com.onedimensiongame.utils.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.gameobjects.GuessButtons;

import java.io.BufferedReader;
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
    private Texture levelCleared, levelFailed;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private Timer timer;
    private BufferedReader bufferedReader;
    private Map<String, String> guessObjectsMap;
    private Preferences prefs;
    private String actualGuessObjectTexturePath;
    private boolean isShowSolution, isFirstLevel = true;

    public LevelFactory(boolean isContinue) {
        this.bufferedReader = new BufferedReader(Gdx.files.internal("files/OriginalLevels.txt").reader());
        this.prefs = Gdx.app.getPreferences("ContinueLevels");
        setGuessObjectsMap(isContinue);

        this.timer = new Timer();
        this.rand = new Random();

        this.levelCleared = new Texture(RIGHT_FEEDBACK);
        this.levelFailed = new Texture(WRONG_FEEDBACK);

        this.spriteBatch = new SpriteBatch();
        this.sprite = new Sprite();
        this.sprite.setSize(200, 200);
        this.sprite.setPosition(Gdx.graphics.getWidth() - (levelCleared.getWidth() / 2), Gdx.graphics.getHeight() - (levelCleared.getHeight() / 2));
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
        this.isFirstLevel = false;

        if (guessObjectsMap.keySet().size() > 0) {
            Object[] tempArray = guessObjectsMap.keySet().toArray();
            String key = (String) tempArray[(int) Math.round(Math.random() * (tempArray.length - 1))];
            actualGuessObjectTexturePath = key;
            return key + " " + guessObjectsMap.get(key);
        } else {
            Gdx.app.exit();
            return null;
        }

    }

    public void removeLevel(String key) throws IOException {
        guessObjectsMap.remove(key);
        prefs.remove(key);
        prefs.flush();
    }

    public String getActualGuessObjectTexturePath() {
        return this.actualGuessObjectTexturePath;
    }

    public boolean getIsShowSolution() {
        return isShowSolution;
    }

    public void setIsShowSolution(boolean isShowSolution) {
        this.isShowSolution = isShowSolution;
    }

    private void setGuessObjectsMap(boolean isContinue) {
        if (!isContinue) {
            this.guessObjectsMap = new HashMap<String, String>();
            prefs.clear();
            getLevelsFromFile();
        } else {
            this.guessObjectsMap = (Map<String, String>) prefs.get();
        }
    }

    private void getLevelsFromFile() {
        String tempString;
        try {
            while ((tempString = bufferedReader.readLine()) != null) {
                String path = tempString.substring(0, tempString.indexOf(" "));
                String solution = tempString.substring(tempString.indexOf(" ") + 1, tempString.length());
                guessObjectsMap.put(path, solution);
            }
            bufferedReader.close();

            prefs.put(guessObjectsMap);
            prefs.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsFirstLevel() {
        return isFirstLevel;
    }
}
