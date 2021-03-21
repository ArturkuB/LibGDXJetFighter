package com.jetfighter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jetfighter.JetFighter;

public class DesktopLauncher {
	//ustawienia okna
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = JetFighter.WIDTH;
		config.height = JetFighter.HEIGHT;
		config.title = JetFighter.TITLE;
		config.resizable = false;
		new LwjglApplication(new JetFighter(), config);
	}
}