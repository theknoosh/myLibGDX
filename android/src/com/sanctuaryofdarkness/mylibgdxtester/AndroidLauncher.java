package com.sanctuaryofdarkness.mylibgdxtester;

import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.sanctuaryofdarkness.mylibgdxtester.GameMain;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		initialize(new GameMain(), config);
	}
}
