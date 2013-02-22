package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.core.entity.FixEntity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

/**
 * 
 * Komponente für sich nicht bewegende, immer an der relativ zum Spieler gleich bleibendne
 * Position bleibend
 * 
 * @author andreas
 *
 */
public class NoMoveComponent extends RenderComponent {
	Image image;
	PlayerEntity me;
	boolean showInformation;
	
	public NoMoveComponent(String id, Image image, PlayerEntity me, boolean showInfo) {
		super(id);
		this.image = image;
		this.me = me;
		this.showInformation = showInfo;
	}
	
	public NoMoveComponent(String id, Image image) {
		super(id);
		this.image = image;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if(owner.getPosition().x >= -800 && owner.getPosition().y >=-600 && owner.getPosition().x <=800 && owner.getPosition().y <=600){
			image.draw(owner.getPosition().x,owner.getPosition().y, 1);
			if(showInformation){
				gr.drawString(((FixEntity)owner).getBezeichnung(), 
								((FixEntity)owner).getPosition().x,	
								((FixEntity)owner).getPosition().y + this.image.getHeight());	
			}				
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		position.x -= me.getSpeed()* java.lang.Math.sin(java.lang.Math.toRadians(me.getRotation()));
		position.y += me.getSpeed()* java.lang.Math.cos(java.lang.Math.toRadians(me.getRotation()));	

	}

}
