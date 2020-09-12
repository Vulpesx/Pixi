package me.potaytoprograms.pixi.p2d.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import me.potaytoprograms.pixi.p2d.box2d.Box2dUtil;
import me.potaytoprograms.pixi.shared.ashley.util.IScript;

public class PhysicsComponent2D implements Component {
	
	public Body body;
	public TransformComponent2D transform;
	
	public PhysicsComponent2D(TransformComponent2D transform, World world, Shape shape, float friction, float restitution, float density, short category, short mask, short group, boolean fixedRotation, boolean isStatic, boolean isSensor, IScript script){
		body = Box2dUtil.createBody(world, shape, friction, restitution, density, category, mask, group, fixedRotation, isStatic, isSensor, script);
		body.getPosition().set(transform.x, transform.y);
		this.transform = transform;
	}
	
	public void updateTransform(){
		transform.x = body.getPosition().x;
		transform.y = body.getPosition().y;
	}
}