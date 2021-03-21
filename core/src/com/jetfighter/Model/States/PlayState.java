package com.jetfighter.Model.States;

import java.awt.Color;
import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetfighter.Controller.GameStateManager;
import com.jetfighter.Model.Jet;
import com.jetfighter.View.JetFighter;

public class PlayState extends State
{
	private boolean paused = false;
	private boolean scoredB = false;
	private boolean scoredW = false;
	private Date startDate1;
	private Date startDate2;
	private Date pauseTime;
	private Date unpauseTime;
	Jet wj = new Jet("C:\\Users\\Artur\\Downloads\\jetfighter\\assets\\white-jet.png", true);
	Jet bj = new Jet("C:\\Users\\Artur\\Downloads\\jetfighter\\assets\\black-jet.png", false);
	private Texture pauseText;
	BitmapFont font = new BitmapFont();
	String scoreB = "0";
	String scoreW = "0";
	protected PlayState(GameStateManager gsm) 
	{
		super(gsm);
		pauseTime = new Date();
		unpauseTime = new Date();
		pauseTime.setTime(0);
		unpauseTime.setTime(0);
		pauseText = new Texture("C:\\Users\\Artur\\Downloads\\jetfighter\\assets\\paused.png");
	}

	@Override
	protected void handleInput() 
	{
		if(paused == false)
		{
			if(Gdx.input.isKeyPressed(Keys.SPACE))
			{
				startDate1 = new Date();
				scoredW = false;
				wj.bullet.shooted = false;
				wj.bullet.x = wj.x;
				wj.bullet.y = wj.y;
				wj.bullet.degrees = wj.degrees;
			}
			if(Gdx.input.isKeyPressed(Keys.ENTER))
			{
				startDate2 = new Date();
				scoredB = false;
				bj.bullet.shooted = false;
				bj.bullet.x = bj.x;
				bj.bullet.y = bj.y;
				bj.bullet.degrees = bj.degrees;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
		{
			Gdx.app.exit();
			this.dispose();
		}
		if(Gdx.input.isKeyPressed(Keys.P))
		{
			pauseTime = new Date();
			paused = true;
		}
		if(Gdx.input.isKeyPressed(Keys.O))
		{
			unpauseTime = new Date();
			paused = false;
		}
	}

	@Override
	public void update(float dt) 
	{
		handleInput(); 
		if(paused == false)
		{
			Date endDate1 = new Date();
			
			if(startDate1 != null) 
			{
				if(((int)(((pauseTime.getTime() - startDate1.getTime()) + (endDate1.getTime() - unpauseTime.getTime())) / 1000) > 0.7))
				{
					wj.bullet.shooted = true;
				}
			}
			
			Date endDate2 = new Date();
			
			if(startDate2 != null) 
			{
				if(((int)(((pauseTime.getTime() - startDate2.getTime()) + (endDate2.getTime() - unpauseTime.getTime())) / 1000) > 0.7))
				{
					bj.bullet.shooted = true;
				}
			}
				
			if(wj.collides(bj.bullet.getRecB()) && (scoredB == false))
			{
				bj.bullet.shooted = true;
				scoreB = Integer.toString(Integer.parseInt(scoreB) + 1);
				scoredB = true;
			}
			if(bj.collides(wj.bullet.getRecB()) && (scoredW == false))
			{
				wj.bullet.shooted = true;
				scoreW = Integer.toString(Integer.parseInt(scoreW) + 1);
				scoredW = true;
			}
			wj.update(dt);
			wj.bullet.update();
			bj.update(dt);
			bj.bullet.update();
		}
	}

	@Override
	public void render(SpriteBatch sb) 
	{
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
		if (paused == true) {
			sb.draw(pauseText, (JetFighter.WIDTH / 2) - (350 / 2), 200, 350, 100);
		}
		sb.end();		
	}

	@Override
	public void dispose() 
	{
		wj.dispose();
		bj.dispose();
		wj.bullet.dispose();
		bj.bullet.dispose();
		if (paused == false) {
			pauseText.dispose();
		}
	}

}
