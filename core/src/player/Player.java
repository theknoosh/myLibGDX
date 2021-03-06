package player;

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
 * Created by Darrell Payne on 7/31/17.
 */

public class Player extends Sprite {

    private World world;
    private Body body;

    public Player(World world, java.lang.String name, float x, float y){
        super(new Texture(name));
        this.world = world;
        setPosition(x - getWidth()/2,y - getHeight()/2 + 200);
        createBody();
    }

    void createBody(){

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // StaticBody is not affected by gravity or outside forces
        // KinimaticBody is not affected by gravity but IS affected by outside forces
        // DynamicBody is affected by gravity AND outside forces

        bodyDef.position.set(getX() / GameInfo.PPM, getY() / GameInfo.PPM);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth()/2) / GameInfo.PPM, (getHeight()/2) / GameInfo.PPM);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Player");

        shape.dispose();
    }

    public void  updatePlayer(){
        this.setPosition(body.getPosition().x * GameInfo.PPM, body.getPosition().y * GameInfo.PPM);
    }

    public Body getBody(){
        return this.body;
    }
}
