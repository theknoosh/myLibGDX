package Scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.sanctuaryofdarkness.mylibgdxtester.GameMain;

/**
 * Created by darrellpayne on 7/30/17.
 */

public class MainMenu implements Screen{

    private GameMain game; // Reference to Game entry point
    private Texture bg;


    public MainMenu(GameMain game){
        this.game = game;
        bg = new Texture("Game BG.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        game.getBatch().begin();
        game.getBatch().draw(bg,0,0);

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

    }
}
