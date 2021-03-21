package com.jetfighter.Controller;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetfighter.Model.States.State;
//Klasa ktora odpowiada za kontrole stanu gry, czyli tryb rozgrywki oraz tryb menu.
public class GameStateManager 
{
	private Stack<State> states;
	
	public GameStateManager()
	{
		states = new Stack<State>();
		
	}
	public void push(State state)
	{
		states.push(state);
	}
	public void pop()
	{
		states.pop();
	}
	public void set(State state)
	{
		states.pop();
		states.push(state);
	}
	public void update(float dt)
	{
		states.peek().update(dt);
	}
	
	public void render(SpriteBatch sb)
	{
		states.peek().render(sb);
	}
}
