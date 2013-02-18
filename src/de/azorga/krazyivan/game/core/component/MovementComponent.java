package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * 
 * 
 * @author andreas
 *
 */
public class MovementComponent extends Component{

	float direction;
	float speed;
	
	public MovementComponent(String id){
		this.id = id;
	}
	
	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float rotation = owner.getRotation();
		float scale = owner.getScale();
		Vector2f position = owner.getPosition();
		
	}

	public float getDirection() {
		return direction;
	}

	public float getSpeed() {
		return speed;
	}

}
