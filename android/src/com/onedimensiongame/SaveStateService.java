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

    private static SaveStateService serviceInstance= new SaveStateService();

    private SaveStateService(){}

    public static SaveStateService getInstance(){
        return serviceInstance;
    }
    public Integer getLevel(Context context){
        return serviceInstance.recoverLvl(context);
    }
    public void  setLevel(int lvl, Context context){
        serviceInstance.saveLvl(lvl, context);
    }
    private void saveLvl(int lvl, Context context){
        try {
            OutputStreamWriter fout= new OutputStreamWriter(context.openFileOutput("mi_fichero.txt", Context.MODE_PRIVATE));
            fout.write(lvl);
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    private Integer recoverLvl(Context context){
        try{
            BufferedReader fin = new BufferedReader(new InputStreamReader(context.openFileInput("mi_fichero.txt")));
            String texto = fin.readLine();
            fin.close();
            return  new Integer((texto==null || texto==""? "0":texto));
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
            return 0;
        }
    }
}
