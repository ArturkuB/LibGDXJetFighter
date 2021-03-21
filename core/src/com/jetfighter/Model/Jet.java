package com.jetfighter.Model;


import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetfighter.View.JetFighter;

public class Jet 
{
	private Vector2 direction;
	private Texture jet;
	private TextureRegion trjet;
	public float x;
	public float y;
	private boolean isWhite;
	private Rectangle recJ;

	public float degrees = 0;
	private float angle = 0;
	private float speed = 1.5f;
	public Bullet bullet;
	private boolean shot = false;
	
	public Jet(String filename, boolean isWhite)
	{
		this.x = 1 + (int)(Math.random() * 500);
		this.y = 1 + (int)(Math.random() * 500);
		this.degrees = (float)Math.random() + (float) Math.random();
		this.isWhite = isWhite;
		jet = new Texture(filename);
		recJ = new Rectangle(x, y, jet.getWidth(), jet.getHeight());
		trjet = new TextureRegion(jet);
	}
	
	public void update(float dt) 
	{
		this.goTheWayWereFacing(dt);
	    this.constrainToMap();
	    recJ.x = this.x;
	    recJ.y = this.y;
	}
	//metoda ktora steruje mysliwiec w strone dzioba i kontrola rotacji za pomoca klawiszy
	public void goTheWayWereFacing(float dt) 
	{
		x += speed * Math.cos(degrees);
		y += speed * Math.sin(degrees);
		if(isWhite)
		{
			if(Gdx.input.isKeyPressed(Keys.A))
			{
		    	degrees = degrees + 0.04f;
			}
		    if(Gdx.input.isKeyPressed(Keys.D))
			{
		    	degrees = degrees - 0.04f;
			}
		}
		else
		{
			if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			{
		    	degrees = degrees + 0.04f;
			}
		    if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			{
		    	degrees = degrees - 0.04f;
			}
		}
	}
	
	public boolean collides(Rectangle bullet)
	{
		if(recJ.overlaps(bullet))
		{
			return true;
		}
		return false;
	}
	//metoda trzymajaca mysliwiec w obrebie okna
	public void constrainToMap()
	{
		 if (this.x < -(jet.getWidth())) {
		        this.x = JetFighter.WIDTH;
		    } 
			else if (this.x > JetFighter.WIDTH) 
			{
		        this.x = 0;
		    } 
		     
		    if (this.y > JetFighter.HEIGHT) 
		    {
		        this.y = 0;
		    } 
		    else if (this.y < -this.jet.getHeight()) 
		    {
		        this.y = JetFighter.HEIGHT;
		    }
	}
	
	public void shoot()
	{
		if(shot == false)
		{
			if(isWhite)
			{
				bullet = new Bullet(this.x, this.y, this.angle, true);
			}
			else
			{
				bullet = new Bullet(this.x, this.y, this.angle, false);
			}
			shot = true;
		}
		
	}
	
	//metoda rysujaca mysliwiec wraz z kontrola rotacji
	public void draw(SpriteBatch sb)
	{ 
		sb.draw(trjet, x, y, (float)jet.getWidth()/2, (float)jet.getHeight()/2, (float)jet.getWidth(), (float)jet.getHeight(), 1f, 1f, degrees*57);
	}
	
	public void dispose()
	{
		jet.dispose();
	}
	
}
