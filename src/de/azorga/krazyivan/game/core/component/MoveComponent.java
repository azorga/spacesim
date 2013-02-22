package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.core.entity.FixEntity;
import de.azorga.krazyivan.game.core.entity.MovingEntity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

/**
 * 
 * Komponente für sich bewegende aber nicht NPC-Komponenten
 * 
 * @author andreas
 *
 */
public class MoveComponent  extends RenderComponent {
	Image image;
	PlayerEntity me;
	
	public MoveComponent(String id, Image image, PlayerEntity me) {
		super(id);
		this.image = image;
		this.me = me;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if(owner.getPosition().x >= 0 && owner.getPosition().y >=0 && owner.getPosition().x <=800 && owner.getPosition().y <=600){
			image.draw(owner.getPosition().x,owner.getPosition().y, 1);	
			gr.drawString(((MovingEntity)owner).getPosition().x + " " + ((MovingEntity)owner).getPosition().y + " " + ((MovingEntity)owner).getObjectSpeed(), 
					((MovingEntity)owner).getPosition().x,	
					((MovingEntity)owner).getPosition().y + this.image.getHeight());	
		}		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();


		position.x -=  ((MovingEntity)owner).getObjectSpeed()* java.lang.Math.sin(java.lang.Math.toRadians(((MovingEntity)owner).getRotation()))
						- me.getSpeed() * java.lang.Math.sin(java.lang.Math.toRadians(me.getRotation()));
					
		position.y +=  ((MovingEntity)owner).getObjectSpeed()* java.lang.Math.cos(java.lang.Math.toRadians(((MovingEntity)owner).getRotation()))
						- me.getSpeed() * java.lang.Math.sin(java.lang.Math.toRadians(me.getRotation()));
						
		
		
	}

}
