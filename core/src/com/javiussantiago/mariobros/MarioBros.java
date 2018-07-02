package com.javiussantiago.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.javiussantiago.mariobros.screens.PlayScreen;

public class MarioBros extends Game
{
    public static final int V_WIDTH = 400;  //virtual width
    public static final int V_HEIGHT = 208; //virtual height
    public static final float PPM = 100;    //pixels per minute scale factor

    //filters?
    public static final short DEFAULT_BIT = 1;
    public static final short MARIO_BIT = 2;
    public static final short BRICK_BIT = 4;
    public static final short COIN_BIT = 8;
    public static final short DESTROYED_BIT = 16;

	public SpriteBatch batch;   //public so all screens can use it

    public static AssetManager manager;

	@Override
	public void create ()
    {
		batch = new SpriteBatch();
	    manager = new AssetManager();
	    manager.load("audio/music/mario_music.ogg", Music.class);
	    manager.load("audio/sounds/coin.wav", Sound.class);
        manager.load("audio/sounds/bump.wav", Sound.class);
        manager.load("audio/sounds/breakblock.wav", Sound.class);
        manager.finishLoading();

		setScreen(new PlayScreen(this));    //passes this game itself

    }

	@Override
	public void render ()
    {
        super.render();     //delegates render to wtvr screen is active
        manager.update();
	}
	
	@Override
	public void dispose ()
    {
		batch.dispose();
		super.dispose();
		manager.dispose();
	}
}
