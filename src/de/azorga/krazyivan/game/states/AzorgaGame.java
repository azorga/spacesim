package de.azorga.krazyivan.game.states;
import java.util.ArrayList;
import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import de.azorga.krazyivan.game.client.ClientThread;
import de.azorga.krazyivan.game.core.component.EllipsePolygonComponent;
import de.azorga.krazyivan.game.core.component.ImageRenderComponent;
import de.azorga.krazyivan.game.core.component.PlayerMouseMovementComponent;
import de.azorga.krazyivan.game.core.component.PlayerMovementComponent;
import de.azorga.krazyivan.game.core.component.PolygonComponent;
import de.azorga.krazyivan.game.core.component.RectangularPolygonComponent;
import de.azorga.krazyivan.game.core.component.WeaponComponent;
import de.azorga.krazyivan.game.core.entity.Entity;
import de.azorga.krazyivan.game.core.entity.FixEntity;
import de.azorga.krazyivan.game.core.entity.MovingEntity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;
import de.azorga.krazyivan.game.effects.AzorgaParticleSystem;
import de.azorga.krazyivan.game.tools.EntitiyCreator;
import de.azorga.krazyivan.game.tools.MusicLoader;


public class AzorgaGame extends BasicGameState implements MusicListener{
	/**
	 * Gamestate
	 */
	public static final int ID = 3;
	/**
	 * IP-Adresse des Servers
	 */
	public static String server_ip = null;
	/**
	 * Name des Spielers
	 */
	public static String playername = null;
	/**
	 * Verbunden oder nicht
	 */
	private boolean connected = false;
	/**
	 * ClientThread-Objekt
	 */
	ClientThread ct;
	/**
	 * Entity-Listen
	 */
	Vector<PlayerEntity> players;
	Vector<FixEntity> planets = new Vector<FixEntity>();
	Vector<FixEntity> stars = new Vector<FixEntity>();
	Vector<MovingEntity> asteroids = new Vector<MovingEntity>();
	Vector<Entity> lasers = new Vector<Entity>();
	Vector<FixEntity> starbases = new Vector<FixEntity>();
	/**
	 * Spieler
	 */
	PlayerEntity me = null;
	/**
	 * ArrayList mit allen Musikstücken
	 */
	ArrayList<Music> tracklist = new ArrayList<Music>();
	/**
	 * Gegenwärtig gespielter Track
	 */
	int currentMusicTrack = 0;
	/**
	 * Gamemap
	 */
	TiledMap map;
	/**
	 * Relative Position der Gamemap
	 */
	float mapX = 0f;
	float mapY = 0f;

	
	
	
	
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		if(!(me == null)){
			map.render((int)mapX, (int)mapY);
			me.render(container, null, g);
			for(Entity laser: lasers){
				laser.render(container, null, g);
			}
			for(FixEntity planet : planets){
				planet.render(container, null, g);
			}
			for(FixEntity star : stars){
				star.render(container, null, g);
			}
			for(FixEntity starbase : starbases){
				starbase.render(container, null, g);
			}
			for(MovingEntity asteroid : asteroids){
				asteroid.render(container, null, g);
			}
		}
		/**
		 * Ein paar Ausgaben auf der GUI
		 */
		g.drawString(me.getPlayername(), 10, 10 
				+ ((ImageRenderComponent)me.getComponent("merender")).getImage().getHeight());
		g.drawString("Geschwindigkeit: " + me.getSpeed(), 210, 10 
				+ ((ImageRenderComponent)me.getComponent("merender")).getImage().getHeight());
		g.drawString("Rotation: " + me.getRotation(), 410, 10 
				+ ((ImageRenderComponent)me.getComponent("merender")).getImage().getHeight());
		g.drawString("Position" + Math.abs(me.getPosition().x) + " " + Math.abs(me.getPosition().y), 610, 10 
				+ ((ImageRenderComponent)me.getComponent("merender")).getImage().getHeight());
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		if(!connected){
			//connect();
			loadmusic();
			createplayer();
			createmap();
			createuniverse();
			connected = true;
		}else{
			if(!(me == null)){
				Input input  = container.getInput();
				if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
					Entity laser = new Entity("laser", 400, 300);
					laser.AddComponent(new WeaponComponent("lasermovement", new Image("resources/entities/laser.gif"), me));
					laser.AddComponent(new RectangularPolygonComponent("mepolygon", new Image("resources/entities/laser.gif")));
					((PolygonComponent) laser.getComponent("mepolygon")).createPolygon();
					laser.setSpeed((float) 1.5);
					laser.setRotation(me.getRotation());
					lasers.add(laser);
				}
				me.update(container, null, delta);
				for(Entity laser: lasers){
					laser.update(container, null, delta);
				}
				for(FixEntity planet : planets){
					planet.update(container, null, delta);
				}
				for(FixEntity star : stars){
					star.update(container, null, delta);
				}
				for(FixEntity starbase : starbases){
					starbase.update(container, null, delta);
				}
				for(MovingEntity asteroid : asteroids){
					asteroid.update(container, null, delta);
				}

			}
		}

	}

	/**
	 * Wird später im Server-Teil ausgeführt
	 * @throws SlickException 
	 */
	private void createuniverse() throws SlickException {
		//dynamisieren
		planets = EntitiyCreator.createPlanets(800, me);
		stars = EntitiyCreator.createStars(10000, me);
		starbases = EntitiyCreator.createBases(600, me);
		asteroids = EntitiyCreator.createAsteroids(10000, me);
	}

	private void createplayer() throws SlickException {
		me = new PlayerEntity("me",400,300);
		me.AddComponent(new ImageRenderComponent("merender", new Image("resources/player/spacecraft.gif", Color.white)));
		me.AddComponent(new PlayerMovementComponent("memovement"));
		me.AddComponent(new RectangularPolygonComponent("mepolygon", new Image("resources/player/spacecraft.gif")));
		((PolygonComponent) me.getComponent("mepolygon")).createPolygon();
		me.AddComponent(new EllipsePolygonComponent("mesensor", null, 60));
		((EllipsePolygonComponent)me.getComponent("mesensor")).createPolygon();
		me.setPlayername(playername);
		me.AddComponent(new PlayerMouseMovementComponent("memouse"));
		me.setRotation(0);
		me.setSpeed(0);
	}

	private void createmap() throws SlickException {
		/**
		 * Map-Objekt erzeugen
		 */
		map = new TiledMap("resources/map/map1.tmx");
		map.render(0, 0);
		
		
	}

	private void loadmusic() throws SlickException {
		try{
			tracklist = MusicLoader.loadMusic(this);
		}catch(SlickException ex){
			ex.printStackTrace();
		}
		currentMusicTrack = 18;
		tracklist.get(currentMusicTrack).play(1, 0.1f);
		
	}

	private void connect() {
		System.out.println("Starting to connect");
		ct = new ClientThread(server_ip);
		ct.start();
		me = (PlayerEntity) ct.getMe();
		players = ct.getPlayers();
		connected = true;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void musicEnded(Music music) {
		currentMusicTrack = (int) (Math.random()*tracklist.size());
		System.out.println(currentMusicTrack);
		tracklist.get(currentMusicTrack).play(1, 0.1f);		
	}

	@Override
	public void musicSwapped(Music music, Music newMusic) {
		// TODO Auto-generated method stub		
	}

}
