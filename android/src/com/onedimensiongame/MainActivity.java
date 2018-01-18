package com.onedimensiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private static boolean isResume = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button resumeButton =  findViewById(R.id.buttonContinue);
        //TODO page needs to refresh when goign back
/*        resumeButton.setEnabled(false);
        if (Gdx.app != null){
            if (!Gdx.app.getPreferences("ContinueLevels").get().isEmpty()) resumeButton.setEnabled(true);
        }*/
    }

    public void handleStartButton(View view) {
        this.isResume = false;
        Intent intent = new Intent(this, AndroidLauncher.class);
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }

    public void handleResumeButton(View view) {
        this.isResume = true;
        Intent intent = new Intent(this, AndroidLauncher.class);
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }

    public void handleExitButton(View view) {
        finish();
    }

    public static boolean getIsResume(){
        return isResume;
    }
}
