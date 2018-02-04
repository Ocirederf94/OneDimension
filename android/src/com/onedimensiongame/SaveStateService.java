package com.onedimensiongame;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by fabian.sanchez on 31/01/2018.
 */

public final class SaveStateService {

    private static SaveStateService serviceInstance = new SaveStateService();

    private SaveStateService() {
    }

    public static SaveStateService getInstance() {
        return serviceInstance;
    }

    public Integer getLevel(Context context) {
        return serviceInstance.recoverLvl(context);
    }

    public void setLevel(int level, Context context) {
        serviceInstance.saveLvl(level, context);
    }

    private void saveLvl(int lvl, Context context) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput("levels_file.txt", Context.MODE_PRIVATE));
            writer.write(lvl);
            writer.close();
        } catch (Exception ex) {
            Log.e("Files", "SaveStateService : Error while writing to memory");
        }
    }

    private Integer recoverLvl(Context context) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.openFileInput("levels_file.txt")));
            String levelString = reader.readLine();
            reader.close();
            return levelString == null ? 0 : Integer.valueOf(levelString);
        } catch (Exception ex) {
            Log.e("Files", "SaveStateService : Error while reading from memory");
            return 0;
        }
    }
}
