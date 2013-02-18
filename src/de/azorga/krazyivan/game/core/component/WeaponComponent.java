package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.core.entity.Entity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

/**
 * 
 * Komponente für Waffen
 * 
 * @author andreas
 *
 */
public class WeaponComponent  extends RenderComponent{
	Image image;
	Boolean hardPolygon = false;
	PlayerEntity me = null;
	
	public Boolean getHardPolygon() {
		return hardPolygon;
	}

	public void setHardPolygon(Boolean hardPolygon) {
		this.hardPolygon = hardPolygon;
	}

	public WeaponComponent(String id, Image image, PlayerEntity me) {
		super(id);
		this.image = image;
		this.me = me;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		//ImageRenderComponent irc = (ImageRenderComponent) me.getComponent("merender");
		//Vector2f position = new Vector2f(owner.getPosition().x + irc.getImage().getHeight()/2, owner.getPosition().y + irc.getImage().getWidth()/2);
		Vector2f position = owner.getPosition();
		position.x += owner.getSpeed() * java.lang.Math.sin(java.lang.Math.toRadians(owner.getRotation()));
		position.y -= owner.getSpeed() * java.lang.Math.cos(java.lang.Math.toRadians(owner.getRotation()));	
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {		
		image.draw(owner.getPosition().x,owner.getPosition().y, 1);
	}
	
	public boolean colisiondetection(Entity ent){
		return false;
	}

}
