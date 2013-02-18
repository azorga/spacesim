package de.azorga.krazyivan.game.core.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.core.component.Component;
import de.azorga.krazyivan.game.core.component.RenderComponent;
/**
 * 
 * Oberklasse für alle Entitäten im Spiel
 * 
 * @author andreas
 *
 */
public class Entity extends Animation{
	String id;
	Vector2f position;
	float scale;
	float rotation;
	
	RenderComponent renderComponent = null;
	
	ArrayList<Component> components = null;
	
	/**
	 * 
	 * @param id
	 */
	public Entity(String id){
		this(id, 0, 0);
	}
	
	public Entity(String id, float x, float y){
		this.id = id;
		
		components = new ArrayList<Component>();
		
		position = new Vector2f(x,y);
		
		scale = 1;
		
		rotation = 0;
		

	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void AddComponent(Component component){
		if(RenderComponent.class.isInstance(component)){
			renderComponent = (RenderComponent) component;
		}
		
		component.setOwnerEntity(this);
		components.add(component);
	}
	
	public Component getComponent(String id){
		for(Component comp:components){
			if(comp.getId().equalsIgnoreCase(id)){
				return comp;
			}
		}
		return null;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
    public void update(GameContainer gc, StateBasedGame sb, int delta)
    {
        for(Component component : components)
        {
            component.update(gc, sb, delta);
        }
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
    {
        if(renderComponent != null)
            renderComponent.render(gc, sb, gr);
    }
	
	
	
}
