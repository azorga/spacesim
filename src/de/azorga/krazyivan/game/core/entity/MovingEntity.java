package de.azorga.krazyivan.game.core.entity;

public class MovingEntity extends Entity {

	boolean destroyable = false;
	float speed = 0;
	
	public MovingEntity(String id,  boolean destroyable, float speed) {
		super(id);
		// TODO Auto-generated constructor stub
		this.destroyable = destroyable;
		this.speed = speed;
	}
	
	public float getObjectSpeed(){
		return this.speed;
	}
	
	

}
