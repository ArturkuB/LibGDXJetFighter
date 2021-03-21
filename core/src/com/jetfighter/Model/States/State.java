package com.jetfighter.Model.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.jetfighter.Controller.GameStateManager;

public abstract class State 
{
	protected GameStateManager gsm;
	
	protected State(GameStateManager gsm)
	{
		this.gsm = gsm;
	}
	
	
	protected abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render(SpriteBatch sb);
	public abstract void dispose();
}
