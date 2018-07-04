package com.javiussantiago.mariobros.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.javiussantiago.mariobros.screens.PlayScreen;

public abstract class Enemy extends Sprite
{
    protected World world;
    protected PlayScreen playScreen;
    public Body b2body;

    public Enemy(PlayScreen playScreen, float x, float y)
    {
        this.world = playScreen.getWorld();
        this.playScreen = playScreen;
        setPosition(x, y);
        defineEnemy();
    }

    protected abstract void defineEnemy();
}
