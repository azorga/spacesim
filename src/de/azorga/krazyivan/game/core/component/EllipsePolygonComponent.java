package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.state.StateBasedGame;
/**
 * 
 * Kopmonente für ein kreisförmiges Polygon um eine Entität, z.B. für Radar, Fog-of-War etc
 * 
 * @author andreas
 *
 */
public class EllipsePolygonComponent extends PolygonComponent{
	Ellipse entitypoly;
	int radius;
	
	public EllipsePolygonComponent(String id, Image image, int radius) {
		super(id, image);
		this.radius = radius;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		entitypoly.setLocation(owner.getPosition().x, owner.getPosition().y);		
	}

	@Override
	public void createPolygon() {
		entitypoly = new Ellipse(owner.getPosition().x, owner.getPosition().y, radius, radius);
	}
	


}
