package de.azorga.krazyivan.game.tools;

import java.util.Vector;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.azorga.krazyivan.game.core.component.ImageRenderComponent;
import de.azorga.krazyivan.game.core.component.MoveComponent;
import de.azorga.krazyivan.game.core.component.NoMoveComponent;
import de.azorga.krazyivan.game.core.component.PolygonComponent;
import de.azorga.krazyivan.game.core.component.RectangularPolygonComponent;
import de.azorga.krazyivan.game.core.entity.FixEntity;
import de.azorga.krazyivan.game.core.entity.MovingEntity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

public class EntitiyCreator {
	public static Vector<FixEntity> createPlanets(int count, PlayerEntity me) throws SlickException{
		Vector<FixEntity> result = new Vector<FixEntity>();
		Image referenceImage = new Image("resources/entities/planet.gif");
		for(int i = 0; i<count; i++){			
			String bezeichnung = RandomNameGenerator.getRandomPlanetName();
			FixEntity temp = new FixEntity(bezeichnung);
			temp.setBezeichnung(bezeichnung);
			temp.AddComponent(new ImageRenderComponent("merender", referenceImage));
			temp.AddComponent(new RectangularPolygonComponent("mepolygon", referenceImage));
			((PolygonComponent) temp.getComponent("mepolygon")).createPolygon();
			temp.setPosition(new Vector2f(myRandom(-15000, 15000), myRandom(-15000, 15000)));
			temp.AddComponent(new NoMoveComponent("planetmovement", referenceImage, me, true));
			result.add(temp);
		}
		return result;
	}
	
	private static int myRandom(int low, int high) {
		return (int) (Math.random() * (high - low) + low);
	}
	

	public static Vector<FixEntity> createStars(int count, PlayerEntity me) throws SlickException {
		Vector<FixEntity> result = new Vector<FixEntity>();
		Image referenceImage = new Image("resources/entities/star.gif");
		for(int i = 0; i<count; i++){
			String bezeichnung = RandomNameGenerator.getRandomPlanetName();
			FixEntity temp = new FixEntity(bezeichnung);
			temp.AddComponent(new ImageRenderComponent("merender", referenceImage));
			temp.setPosition(new Vector2f(myRandom(-15000, 15000), myRandom(-15000, 15000)));
			temp.AddComponent(new NoMoveComponent("starmovement", referenceImage, me, false));
			result.add(temp);
		}
		return result;
	}

	public static Vector<FixEntity> createBases(int count, PlayerEntity me) throws SlickException {
		Vector<FixEntity> result = new Vector<FixEntity>();
		Image referenceImage = new Image("resources/entities/starbase.gif");
		for(int i = 0; i<count; i++){
			String bezeichnung = RandomNameGenerator.getRandomStarbaseName();
			FixEntity temp = new FixEntity(bezeichnung);
			temp.setBezeichnung(bezeichnung);
			temp.AddComponent(new ImageRenderComponent("merender", referenceImage));
			temp.AddComponent(new RectangularPolygonComponent("mepolygon", referenceImage));
			((PolygonComponent) temp.getComponent("mepolygon")).createPolygon();
			temp.setPosition(new Vector2f(myRandom(-15000, 15000), myRandom(-15000, 15000)));
			temp.AddComponent(new NoMoveComponent("basemovement", referenceImage, me, true));
			result.add(temp);
		}
		return result;
	}	
	
	public static Vector<MovingEntity> createAsteroids(int count, PlayerEntity me) throws SlickException{
		Vector<MovingEntity> result = new Vector<MovingEntity>();
		Image referenceImage = new Image("resources/entities/asteroid.gif");
		for(int i = 0; i<count; i++){
			MovingEntity temp = new MovingEntity("asteroid",  true, 0.1f);
			temp.AddComponent(new ImageRenderComponent("merender", referenceImage));
			temp.AddComponent(new RectangularPolygonComponent("mepolygon", referenceImage));
			((PolygonComponent) temp.getComponent("mepolygon")).createPolygon();
			temp.setPosition(new Vector2f(myRandom(-15000, 15000), myRandom(-15000, 15000)));
			temp.setRotation((myRandom(1, 360))/10);
			temp.AddComponent(new MoveComponent("basemovement", referenceImage, me));
			temp.setScale(0.4f);
			result.add(temp);
		}
		return result;
	}
}
