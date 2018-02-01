package com.onedimensiongame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.badlogic.gdx.Gdx;

import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    private Button resumeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resumeButton = findViewById(R.id.buttonContinue);
        setResumeButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setResumeButton();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void handleStartButton(View view) {
        handleButton(view);
    }

    public void handleResumeButton(View view) {
        handleButton(view);
    }

    public void handleExitButton(View view) {
        finish();
    }

    private void handleButton(View view){
        Intent intent = new Intent(this, AndroidLauncher.class);
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }

    private void setResumeButton(){
        resumeButton.setEnabled(false);
        if (Gdx.app != null) {
            if (!Gdx.app.getPreferences("continueLevel").get().isEmpty())
                resumeButton.setEnabled(true);
        }
    }


    private int recoverLvl() throws Exception{
        try {
            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("mi_fichero.txt", Context.MODE_PRIVATE));
            fout.write("Esto es una prueba!");
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
            return 1;
        }

        return 0;

    }

}
