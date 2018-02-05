package com.onedimensiongame;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by fabian.sanchez on 31/01/2018.
 */

public final class SaveStateService {

    private final static String FILE_NAME = "levels_file.txt";
    private static SaveStateService serviceInstance = new SaveStateService();
    private static File file;

    private SaveStateService() {
    }

    public static SaveStateService getInstance(Context context) {
      /*  if (context.getFileStreamPath(FILE_NAME) != null) {
            file = context.getFileStreamPath(FILE_NAME);
        } else {
            file = new File(context.getFilesDir(), FILE_NAME);
        }*/

        return serviceInstance;
    }

    public Integer getLevel(Context context) {
        return serviceInstance.recoverLvl(context);
    }

    public void setLevel(String level, Context context) {
        serviceInstance.saveLvl(level, context);
    }

    private void saveLvl(String lvl, Context context) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter((context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)));
            writer.write(lvl);
            writer.close();
        } catch (Exception ex) {
            Log.e("Files", "SaveStateService : Error while writing to memory");
        }
    }

    private Integer recoverLvl(Context context) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.openFileInput(FILE_NAME)));
            String levelString = reader.readLine();
            reader.close();
            return levelString == null ? 0 : Integer.valueOf(levelString);
        } catch (Exception ex) {
            Log.e("Files", "SaveStateService : Error while reading from memory");
            return 0;
        }
    }
}
