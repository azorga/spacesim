package de.azorga.krazyivan.game.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.states.AzorgaGame;
import de.azorga.krazyivan.game.states.LoadConnect;
import de.azorga.krazyivan.game.states.MainMenu;

public class Azorga extends StateBasedGame{
	public static int currentstate = 1;
	
	
	
	public Azorga() {
		super("Azorga");
		addState(new MainMenu());
		addState(new LoadConnect());
		addState(new AzorgaGame());
		enterState(MainMenu.ID);
		
	}

	public static void main(String[] args){
		try {
			/**
			 * VERTEXT_ARRAY_RENDERER verwenden, da dieser mit
			 * der Vielzahl erzeugter Sprites besser klar kommt
			 */
			Renderer.setRenderer(Renderer.VERTEX_ARRAY_RENDERER);
			AppGameContainer app = new AppGameContainer(new Azorga());
			/**
			 * 800*600 Desktopanwendung
			 */
			app.setDisplayMode(800, 600, false);
			/**
			 * FPS so viel wie Bildwiederholrate des Monitors
			 */
			//app.setVSync(true);
			
			
			
			app.setTargetFrameRate(60);
			app.setSmoothDeltas(false);
			app.setUpdateOnlyWhenVisible(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	
}
