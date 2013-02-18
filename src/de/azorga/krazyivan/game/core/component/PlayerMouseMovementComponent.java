package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.core.entity.PlayerEntity;

/**
 * 
 * Komponente für Maussteuerung des Spielers
 * 
 * @author andreas
 *
 */
public class PlayerMouseMovementComponent  extends Component{

	float targetX;
	float targetY;
	float targetAng;
	Vector2f direction;
	
	public PlayerMouseMovementComponent(String id){
		this.id = id;
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {			
		Input input  = gc.getInput();	
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
		    float radiansToMouse = (float) Math.atan2(400 - input.getMouseX(), 300 - input.getMouseY());
		    float degreesToMouse = (57.2957795f * radiansToMouse) * -1;
			((PlayerEntity)owner).setRotation(degreesToMouse);
		}		
	}
	


}
