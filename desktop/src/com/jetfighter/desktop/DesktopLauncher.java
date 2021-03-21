package com.jetfighter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jetfighter.View.JetFighter;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
	{
		//ustawienia okna
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = JetFighter.WIDTH;
		config.height = JetFighter.HEIGHT;
		config.title = JetFighter.TITLE;
		config.resizable = false;
		new LwjglApplication(new JetFighter(), config);
	}
}