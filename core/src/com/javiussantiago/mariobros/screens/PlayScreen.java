package com.javiussantiago.mariobros.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.javiussantiago.mariobros.MarioBros;
import com.javiussantiago.mariobros.scenes.Hud;

public class PlayScreen implements Screen
{
    private MarioBros game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    public PlayScreen(MarioBros game)
    {
        this.game = game;

        gameCam = new OrthographicCamera(); //follows mario
        gamePort = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_HEIGHT,gameCam);   //maintains aspect ratios
        hud = new Hud(game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("level1cleaned.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
    }

    public void handleInput(float dt)
    {
        if(Gdx.input.isTouched())
            gameCam.position.x += 100 * dt;
    }

    public void update(float dt)
    {
        handleInput(dt);  //check input
        gameCam.update();   //update camera
        renderer.setView(gameCam);

    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float dt)
    {
        update(dt);
        /*dx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        renderer.render();
    }

    @Override
    public void resize(int width, int height)
    {
        gamePort.update(width, height);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
