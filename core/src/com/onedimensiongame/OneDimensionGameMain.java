package com.onedimensiongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.onedimensiongame.views.MainView;

public class OneDimensionGameMain extends ApplicationAdapter {
	private MainView mainView;
	
	@Override
	public void create () {
		mainView = new MainView();
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
