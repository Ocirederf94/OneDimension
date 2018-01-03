package com.onedimensiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    private static boolean isResume = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
