package com.onedimensiongame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    private static final String CURRENT_LEVEL = "current_level";

    private Button resumeButton;
    private static Map<String, Integer> dataContainer = new HashMap<>(1);
    private SaveStateService saveStateService;
    private Context context;
    private MediaPlayer mainMenuMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getBaseContext();

        mainMenuMusic = setUpMainMenuMusic();
        mainMenuMusic.start();

        saveStateService = SaveStateService.getInstance(context);
        dataContainer.put(CURRENT_LEVEL, saveStateService.getLevel(context));

        resumeButton = findViewById(R.id.buttonContinue);
        setResumeButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainMenuMusic.start();
        saveLevel();
        setResumeButton();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainMenuMusic.pause();
        saveLevel();
    }

    @Override
    protected void onDestroy() {
        saveLevel();
        mainMenuMusic.pause();
        super.onDestroy();
    }

    public void handleStartButton(View view) {
        dataContainer.put(CURRENT_LEVEL, 0);
        handleButton();
    }

    public void handleResumeButton(View view) {
        handleButton();
    }

    public void handleExitButton(View view) {
        finish();
    }

    private void handleButton() {
        Intent intent = new Intent(this, AndroidLauncher.class);
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }

    private void setResumeButton() {
        resumeButton.setEnabled(dataContainer.get(CURRENT_LEVEL) > 0);
    }

    private void saveLevel() {
        saveStateService.setLevel(String.valueOf(dataContainer.get(CURRENT_LEVEL)), context);
    }

    private MediaPlayer setUpMainMenuMusic() {

        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            AssetFileDescriptor fileDescriptor = getAssets().openFd("audio/main_menu_music.mp3");
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
            return mediaPlayer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class AndroidLauncher extends AndroidApplication {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            try {
                initialize(new OneDimensionGameMain(dataContainer));
            } catch (Exception e) {
                Log.e("Nah", "MainActivity: Error in Initializing OneDimensionGameMain ");
            }
        }
    }

}
