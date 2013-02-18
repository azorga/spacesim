package de.azorga.krazyivan.game.core.entity;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;



public class ExplosionEntity extends FixEntity {
	
	private ParticleSystem system;
	private ConfigurableEmitter emitter;
	
	public ExplosionEntity(String id, String path) {
		super(id);
		try {
			init(path);
		} catch (SlickException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private void init(String path) throws SlickException, IOException {
		Image image = new Image("resources/entities/particle.tga", false);
		system = new ParticleSystem(image,1500);
		File xmlFile = new File("resources/xml/explosion1.xml");
		emitter = ParticleIO.loadEmitter(xmlFile);
		emitter.setPosition(100, 100);
		system.addEmitter(emitter);
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta)
    {
		system.update(delta);
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
    {
    	system.render();
    }
	
}
