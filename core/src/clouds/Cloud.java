package clouds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

/**
 * Created by Darrell Payne on 8/1/17.
 */

public class Cloud extends Sprite{

    private World world;
    private Body body;

    public Cloud(World world){
        super((new Texture("Cloud 1.png")));
        this.world = world;
        setPosition((GameInfo.WIDTH / 2f) - 40f, GameInfo.HEIGHT / 2f - 130);
        createBody();
    }

    void createBody(){

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        // StaticBody is not affected by gravity or outside forces
        // KinimaticBody is not affected by gravity but IS affected by outside forces
        // DynamicBody is affected by gravity AND outside forces

        bodyDef.position.set(getX() / GameInfo.PPM, getY() / GameInfo.PPM);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2) / GameInfo.PPM, (getHeight()/2) / GameInfo.PPM);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Cloud");
        fixture.setSensor(true); // If setSensor is true, collision is detected, but object passes through it

        shape.dispose();
    }

}
