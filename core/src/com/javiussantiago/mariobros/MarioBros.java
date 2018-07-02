package com.javiussantiago.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.javiussantiago.mariobros.screens.PlayScreen;

public class MarioBros extends Game
{
    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;
    public static final float PPM = 100;

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
