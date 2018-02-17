package com.onedimensiongame.utils.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.onedimensiongame.gameobjects.GuessButtons;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static com.onedimensiongame.utils.GameConstants.FEEDBACK_TIME;
import static com.onedimensiongame.utils.GameConstants.RIGHT_FEEDBACK;
import static com.onedimensiongame.utils.GameConstants.WRONG_FEEDBACK;

/**
 * Created by fredy on 26/11/2017.
 */

public class LevelFactory {

    private Texture levelCleared, levelFailed;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private Timer timer;
    private List<Map> guessObjectsMapList;
    private Map<String, Integer> dataContainer;
    private boolean isShowSolution;
    private boolean isLastLevel = false;
    private boolean isFirstLevel = true;
    private Integer currentLevel;

    public LevelFactory(Map<String, Integer> dataContainer) {
        this.dataContainer = dataContainer;
        currentLevel = dataContainer.get("current_level");
        initializeGuessObjectsMap();

        this.timer = new Timer();

        this.levelCleared = new Texture(RIGHT_FEEDBACK);
        this.levelFailed = new Texture(WRONG_FEEDBACK);

        this.spriteBatch = new SpriteBatch();
        this.sprite = new Sprite();
        this.sprite.setSize(200, 200);
        this.sprite.setPosition(Gdx.graphics.getWidth() - (levelCleared.getWidth() / 2), Gdx.graphics.getHeight() - (levelCleared.getHeight() / 2));
    }


    //TODO Fabian say he doesn´t want feedback... lets see what we do about it
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

    public LevelsEnum getNextLevel() {
        this.isFirstLevel = currentLevel.equals(0);
        dataContainer.put("current_level", currentLevel);
        String path = (String) guessObjectsMapList.get(currentLevel).keySet().iterator().next();
        String solution = (String) guessObjectsMapList.get(currentLevel).get(path);
        return new LevelsEnum(path, solution, currentLevel++);
    }

    public boolean getIsShowSolution() {
        return isShowSolution;
    }

    public void setIsShowSolution(boolean isShowSolution) {
        this.isShowSolution = isShowSolution;
    }

    private void initializeGuessObjectsMap() {
        this.guessObjectsMapList = new ArrayList<Map>();
        getLevelsFromFile();
    }

    private void getLevelsFromFile() {
        String line;
        BufferedReader bufferedReader = new BufferedReader(Gdx.files.internal("files/OriginalLevels.txt").reader());
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempString = line.split(";");
                Map<String, String> element = new HashMap<String, String>();
                element.put(tempString[0], tempString[1]);
                guessObjectsMapList.add(element);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsFirstLevel() {
        return isFirstLevel;
    }

    public boolean getIsLastLevel() {
        return isLastLevel;
    }
}
