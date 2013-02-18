package de.azorga.krazyivan.game.effects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ParticleSystem;

import de.azorga.krazyivan.game.core.entity.PlayerEntity;

public class AzorgaParticleSystem {
	private ParticleSystem system;
	private int mode = ParticleSystem.BLEND_COMBINE;
	PlayerEntity me;
	
	
	public AzorgaParticleSystem(PlayerEntity me){
		try {
			Image image = new Image("resources/entities/particle.tga");
			system = new ParticleSystem(image);
			system.setBlendingMode(mode);
			system.addEmitter(new NebulaEmitter(600, 400, 40, me));
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void render(GameContainer container, Graphics g) {
		for (int i=0;i<100;i++) {
			g.translate(1,1);
			system.render();
		}
		g.resetTransform();
	}

	/**
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	public void update(GameContainer container, int delta) {
		system.update(delta);
	}
}
