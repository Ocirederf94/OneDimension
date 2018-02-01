package com.onedimensiongame;

import com.badlogic.gdx.Game;
import com.onedimensiongame.views.MainView;

import java.util.Map;

public class OneDimensionGameMain extends Game {

	private MainView mainView;
	private final Map<String,Integer> dataContainer;

	public OneDimensionGameMain(Map<String,Integer> dataContainer){
		this.dataContainer = dataContainer;
	}
	@Override
	public void create () {
		mainView = new MainView(dataContainer);
	}

	@Override
	public void render () {
		mainView.renderMainView();
	}

	@Override
	public void dispose () {
		mainView.disposeMainView();
	}
}
