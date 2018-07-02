package com.javiussantiago.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MarioBros extends Game
{
	public SpriteBatch batch;   //public so all screens can use it

	@Override
	public void create ()
    {
		batch = new SpriteBatch();
	    setScreen(new PlayScreen(this));    //passes this game itself
    }

	@Override
	public void render ()
    {
        super.render();     //delegates render to wtvr screen is active
	}
	
	@Override
	public void dispose ()
    {
		batch.dispose();
	}
}
