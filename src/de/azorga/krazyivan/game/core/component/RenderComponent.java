package de.azorga.krazyivan.game.core.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
/**
 * 
 * Abstrakte, von Component abgeleitete Klasse, die als Oberklasse
 * für alle gerenderten Komponenten agiert
 * 
 * @author Andreas
 *
 */
public abstract class RenderComponent extends Component{

	public RenderComponent(String id){
		super.id = id;
	}
	
	public abstract void render(GameContainer gc, StateBasedGame sb, Graphics gr);
	

}
