package com.jetfighter;

import java.awt.Color;
import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State
{
	private boolean shot;
	private long time;
	private Date startDate;
	Jet wj = new Jet("C:\\Users\\Artur\\eclipse\\My workspace\\jetfighter\\assets\\white-jet.png", true);
	Jet bj = new Jet("C:\\Users\\Artur\\eclipse\\My workspace\\jetfighter\\assets\\black-jet.png", false);
	BitmapFont font = new BitmapFont();
	String scoreB = "0";
	String scoreW = "0";
	protected PlayState(GameStateManager gsm) 
	{
		super(gsm);
	}

	@Override
	protected void handleInput() 
	{
		if(Gdx.input.isKeyPressed(Keys.SPACE))
		{
			startDate = new Date();
			wj.bullet.shooted = false;
			wj.bullet.x = wj.x;
			wj.bullet.y = wj.y;
			wj.bullet.degrees = wj.degrees;
		}
		if(Gdx.input.isKeyPressed(Keys.E))
		{
			bj.bullet.shooted = false;
			bj.bullet.x = bj.x;
			bj.bullet.y = bj.y;
			bj.bullet.degrees = bj.degrees;
		}
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
		{
			Gdx.app.exit();
		}
		
	}

	@Override
	public void update(float dt) 
	{
		Date endDate = new Date();
		if(startDate != null)
		if(((int)((endDate.getTime() - startDate.getTime()) / 1000) > 0.5))
		{
			wj.bullet.shooted = true;
		}
		handleInput(); 
		wj.update(dt);
		wj.bullet.update();
		bj.update(dt);
		bj.bullet.update();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		font.getData().setScale(2);
		font.setColor(0,0,0,1);
		font.draw(sb, scoreB, 125, 450);
		font.setColor(1,1,1,1);
		font.draw(sb, scoreW, 370, 450);
		wj.draw(sb);
		wj.shoot();
		wj.bullet.draw(sb);
		bj.draw(sb);
		bj.shoot();
		bj.bullet.draw(sb);
		sb.end();
		
	}

	@Override
	public void dispose() {
		wj.dispose();
		bj.dispose();
		wj.bullet.dispose();
		bj.bullet.dispose();
	}

}
