package com.jetfighter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State{
	
	private Texture text, text2;
	private BitmapFont font = new BitmapFont();
	
	public MenuState(GameStateManager gsm)
	{
		super(gsm);
		text = new Texture("C:\\Users\\Artur\\eclipse\\My workspace\\jetfighter\\assets\\text.png");
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
		sb.draw(text, (JetFighter.WIDTH / 2) - (450 / 2), 180, 450, 157);
		sb.end();
	}

	@Override
	public void dispose() {
		text.dispose(); 
	}
	

}
