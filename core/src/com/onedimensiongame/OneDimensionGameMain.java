package com.onedimensiongame;

import com.badlogic.gdx.Game;
import com.onedimensiongame.views.MainView;

public class OneDimensionGameMain extends Game {
	private MainView mainView;
	private boolean isResume;

	public OneDimensionGameMain(boolean isResume){
		this.isResume = isResume;
	}

	@Override
	public void create () {
		mainView = new MainView(isResume);
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
