package de.azorga.krazyivan.game.core.entity;

public class MovingEntity extends Entity {

	boolean destroyable = false;
	float speed = 0;
	
	public MovingEntity(String id, float x, float y, boolean destroyable, float speed) {
		super(id, x, y);
		// TODO Auto-generated constructor stub
		this.destroyable = destroyable;
		this.speed = speed;
	}

}
