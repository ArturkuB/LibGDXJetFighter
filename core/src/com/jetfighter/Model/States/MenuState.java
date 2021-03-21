package com.jetfighter.Model.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetfighter.Controller.GameStateManager;
import com.jetfighter.View.JetFighter;

//klasa odpowiadajaca za menu przed wcisnieciem dowolnego klawisza w ktorej pokazane jest sterowanie.
public class MenuState extends State
{
	
	private Texture nameText;
	private Texture controlsText;
	private BitmapFont font = new BitmapFont();
	
	public MenuState(GameStateManager gsm)
	{
		super(gsm);
		nameText = new Texture("C:\\Users\\Artur\\Downloads\\jetfighter\\assets\\text.png");
		controlsText = new Texture("C:\\Users\\Artur\\Downloads\\jetfighter\\assets\\controls.png");
	}

	@Override
	public void handleInput() {
		if(Gdx.input.justTouched())
		{
			gsm.set(new PlayState(gsm));
			dispose();
		}
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.begin();
		sb.draw(nameText, (JetFighter.WIDTH / 2) - (450 / 2), 280, 450, 100);
		sb.draw(controlsText, (JetFighter.WIDTH / 2) - (450 / 2), 100, 450, 130);
		sb.end();
	}

	@Override
	public void dispose() {
		nameText.dispose(); 
	}
	

}
