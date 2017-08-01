package Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.sanctuaryofdarkness.mylibgdxtester.GameMain;

import helpers.GameInfo;
import player.Player;

/**
 * Created by Darrell Payne on 7/30/17.
 */

public class MainMenu implements Screen{

    private GameMain game; // Reference to Game entry point
    private Texture bg;
    private Player player;
    private World world;

    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;

    public MainMenu(GameMain game){
        this.game = game;

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false,GameInfo.WIDTH,GameInfo.HEIGHT);
        box2DCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);

        world = new World(new Vector2(0,-9.8f),true);
        bg = new Texture("Game BG.png");
        player = new Player(world,"player 1.png",GameInfo.WIDTH / 2, GameInfo.HEIGHT / 2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        player.updatePlayer();

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg,0,0);
        game.getBatch().draw(player,player.getX(),player.getY());
        game.getBatch().end();

        world.step(Gdx.graphics.getDeltaTime(),6,2);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bg.dispose();
        player.getTexture().dispose();
    }
}
