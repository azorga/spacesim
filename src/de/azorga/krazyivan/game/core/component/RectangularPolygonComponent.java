package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.StateBasedGame;
/**
 * 
 * Klasse für ein rechteckiges Polygon rund um eine Entität
 * 
 * @author andreas
 *
 */
public class RectangularPolygonComponent extends PolygonComponent{
	
	Polygon entitypoly;
	
	public RectangularPolygonComponent(String id, Image image) {
		super(id, image);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		entitypoly.setX(owner.getPosition().x);
		entitypoly.setY(owner.getPosition().y);	
		entitypoly =(Polygon) entitypoly.transform(
					Transform.createRotateTransform((float)Math.toRadians(delta * owner.getRotation())));
		
	}

	@Override
	public void createPolygon() {
		entitypoly = new Polygon(new float[]{
				owner.getPosition().x,owner.getPosition().y, 
				owner.getPosition().x+image.getWidth(), owner.getPosition().y, 
				owner.getPosition().x+image.getWidth(), owner.getPosition().y+image.getHeight(), 
				owner.getPosition().x,owner.getPosition().y+image.getHeight()
			});
		
	}

}
