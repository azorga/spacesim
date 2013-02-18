package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Abstrakte Komponenten-Klasse für Polygone
 * 
 * @author andreas
 *
 */
public abstract class PolygonComponent extends Component{
	protected Image image;
	
	public PolygonComponent(String id, Image image) {
		this.id = id;
		this.image = image;
	}

	public abstract void update(GameContainer gc, StateBasedGame sb, int delta);

	public abstract void createPolygon();
}
