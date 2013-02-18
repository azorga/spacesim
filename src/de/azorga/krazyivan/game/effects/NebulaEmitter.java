package de.azorga.krazyivan.game.effects;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;

import de.azorga.krazyivan.game.core.entity.PlayerEntity;

public class NebulaEmitter implements ParticleEmitter{
	/** The x coordinate of the center of the fire effect */
	private int x;
	/** The y coordinate of the center of the fire effect */
	private int y;
	
	/** The particle emission rate */
	private int interval = 50;
	/** Time til the next particle */
	private int timer;
	/** The size of the initial particles */
	private float size = 40;
	private PlayerEntity me;
	
	public NebulaEmitter(int x, int y, float size, PlayerEntity me){
		this.x = x;
		this.y = y;
		this.size = size;
		this.me = me;
	}
	
	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#update(org.newdawn.slick.particles.ParticleSystem, int)
	 * 
	 * 
	 * 		Vector2f position = owner.getPosition();
		position.x -= me.getSpeed()* java.lang.Math.sin(java.lang.Math.toRadians(me.getRotation()));
		position.y += me.getSpeed()* java.lang.Math.cos(java.lang.Math.toRadians(me.getRotation()));	
	 * 
	 */
	public void update(ParticleSystem system, int delta) {
		timer -= delta;
		if (timer <= 0) {
			timer = interval;
			Particle p = system.getNewParticle(this, 1000);
			p.setColor(1, 1, 1, 0.5f);
			//float newx = (float) (x - me.getSpeed()* java.lang.Math.sin(java.lang.Math.toRadians(me.getRotation())));
			//float newy = (float) (y + me.getSpeed()* java.lang.Math.cos(java.lang.Math.toRadians(me.getRotation())));
			x -= me.getSpeed()* java.lang.Math.sin(java.lang.Math.toRadians(me.getRotation()));
			y += me.getSpeed()* java.lang.Math.cos(java.lang.Math.toRadians(me.getRotation()));	
			p.setPosition(x, y);
			p.setSize(size);
			float vx = (float) (-0.02f + (Math.random() * 0.04f));
			float vy = (float) (-(Math.random() * 0.15f));
			p.setVelocity(vx,vy,1.1f);
		}
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#updateParticle(org.newdawn.slick.particles.Particle, int)
	 */
	public void updateParticle(Particle particle, int delta) {
		if (particle.getLife() > 600) {
			particle.adjustSize(0.07f * delta);
		} else {
			particle.adjustSize(-0.04f * delta * (size / 40.0f));
		}
		float c = 0.002f * delta;
		particle.adjustColor(0,-c/2,-c*2,-c/4);
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#isEnabled()
	 */
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#completed()
	 */
	public boolean completed() {
		return false;
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#useAdditive()
	 */
	public boolean useAdditive() {
		return false;
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#getImage()
	 */
	public Image getImage() {
		return null;
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#usePoints(org.newdawn.slick.particles.ParticleSystem)
	 */
	public boolean usePoints(ParticleSystem system) {
		return false;
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#isOriented()
	 */
	public boolean isOriented() {
		return false;
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#wrapUp()
	 */
	public void wrapUp() {
	}

	/**
	 * @see org.newdawn.slick.particles.ParticleEmitter#resetState()
	 */
	public void resetState() {
	}

	@Override
	public void resume() {
		throw new UnsupportedOperationException("resume() not implemented for FireEmitter");
	}

}
