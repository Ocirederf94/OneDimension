package com.onedimensiongame;


import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import java.util.HashMap;
import java.util.Map;
import static com.onedimensiongame.SaveStateService.getInstance;

public class AndroidLauncher extends AndroidApplication {

	Map<String,Integer> dataContainer = new HashMap<>(1);

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		dataContainer.put("current_level",getInstance().getLevel(this.getContext()));
		try {
		 initialize(new OneDimensionGameMain(dataContainer));
		}catch (Exception e) {
			Log.e("Nah", "Error al escribir fichero a memoria interna");
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		saveState();
	}

	@Override
	protected void onStop() {
		super.onStop();
		saveState();
	}

	private void saveState(){
		getInstance().setLevel(dataContainer.get("current_level"),this.getContext());
	}
}
