package de.azorga.krazyivan.game.core.component;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.core.entity.PlayerEntity;
/**
 * 
 * Komponente für Tastatursteuerung des Spielers
 * 
 * @author andreas
 *
 */
public class PlayerMovementComponent extends Component{

	float direction;

	
	
	public PlayerMovementComponent(String id){
		this.id = id;
	}



	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float rotation = ((PlayerEntity)owner).getRotation();
		
		Vector2f position = ((PlayerEntity)owner).getPosition();
		
		Input input  = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
		
			rotation += 0.4f;
			
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			
			rotation += -0.5f;
			
		}
		
		if(input.isKeyPressed(Input.KEY_UP)){
		
			((PlayerEntity)owner).setSpeed(0.2f);
			
		}
		
		if(input.isKeyPressed(Input.KEY_DOWN)){
			
			((PlayerEntity)owner).setSpeed(-0.2f);
			
		}
		
		if(input.isKeyPressed(Input.KEY_S)){
			
			((PlayerEntity)owner).fullStop();
			
		}
		((PlayerEntity)owner).setRotation(rotation);
	
		//some maths-magic...
		position.x += ((PlayerEntity)owner).getSpeed() * java.lang.Math.sin(java.lang.Math.toRadians(rotation));
		
		position.y -= ((PlayerEntity)owner).getSpeed() * java.lang.Math.cos(java.lang.Math.toRadians(rotation));

	}

	public float getDirection() {
		return direction;
	}


}
