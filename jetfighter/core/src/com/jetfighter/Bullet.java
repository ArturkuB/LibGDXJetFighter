package com.jetfighter;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet 
{
	public float x;
	public float y;
	public float degrees;
	private boolean isWhite;
	private float speed;
	private long start;
	private float r;
	private Texture im;
	public boolean shooted = true;
	
	public Bullet(float x, float y, float degrees, boolean isWhite) 
	{	
	    this.x = x;
	    this.y = y;
	    this.degrees = degrees;
	    this.isWhite = isWhite;
	    this.speed = 5;
	    this.r = 1.5f;
	    if(isWhite)
	    {
	    	im = new Texture("C:\\Users\\Artur\\eclipse\\My workspace\\jetfighter\\assets\\wbullet.png");
	    }
	    else
	    {
	    	im = new Texture("C:\\Users\\Artur\\eclipse\\My workspace\\jetfighter\\assets\\bbullet.png");
	    }
    }
	
	
		   
	public void update() 
	{
		x += speed * Math.cos(degrees);
		y += speed * Math.sin(degrees);
	    this.constrainToMap();
    }
		   
	//metoda ktora pilnuje aby pociski byly caly czas w obrebie okna	   
	public void constrainToMap() 
	{
		    if (this.x < -this.r) 
		    {
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
		    else if (this.y < -this.r) 
		    {
		        this.y = JetFighter.HEIGHT;
		    }
	}
		   
		   
	public void draw(SpriteBatch sb)
    {
		if(shooted == false)
		{
			sb.draw(im, x, y);
		}
    }
	public void dispose()
	{
		im.dispose();
	}
 }


