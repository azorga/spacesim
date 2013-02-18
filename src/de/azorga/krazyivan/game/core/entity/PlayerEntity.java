package de.azorga.krazyivan.game.core.entity;



public class PlayerEntity extends Entity {
	
	float speed = 0;
	String playername;
	final float maxspeed = 2;
	final float minspeed = -1;
	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		if(this.speed + speed <=maxspeed && this.speed + speed >=minspeed){
			this.speed+= speed;
		}		
	}
	
	public void fullStop(){
		this.speed = 0;
	}

	



	public PlayerEntity(String id, float x, float y) {
		super(id, x, y);
	}

}
