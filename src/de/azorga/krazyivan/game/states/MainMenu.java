package de.azorga.krazyivan.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.main.Azorga;


public class MainMenu extends BasicGameState {
	/**
	 * Gamestate ID
	 */
	public static final int ID = 1;
	/**
	 * Spielobjekt, dass den Status festhält
	 */
	private StateBasedGame game;
	/**
	 * Images für Hintergrund und Buttons
	 */
	Image background = null;
	Image startGame = null;
	Image exitGame = null;
	/**
	 * Musik für MainMenu
	 */
	public static Music music = null;
	/**
	 * Scalings für Buttons
	 */
	float startGameScale = 1;
	float exitGameScale = 1;
	float scaleStep = 0.0001f;
	
    private static int menuX = 200;
    private static int menuY = 400;
    
    private boolean initialized = false;
    
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.game = game;
		music = new Music("resources/mainmenu/menu.wav");
		music.loop(1, 0.5f);
		background = new Image("resources/mainmenu/main_menu.jpg");
		startGame = new Image("resources/mainmenu/main_menu_start.jpg");
		exitGame = new Image("resources/mainmenu/main_menu_exit.jpg");
		initialized = true;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		if(initialized){
			background.draw(0,0);
			startGame.draw(200,400, startGameScale);
			exitGame.draw(200,480, exitGameScale);	
		}


	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		boolean insideStartGame = false;
		boolean insideExit = false;
		
		if( ( mouseX >= menuX && mouseX <= menuX + startGame.getWidth()) &&
			    ( mouseY >= menuY && mouseY <= menuY + startGame.getHeight()) ){
			    insideStartGame = true;
			}else if( ( mouseX >= menuX && mouseX <= menuX+ exitGame.getWidth()) &&
			          ( mouseY >= menuY+80 && mouseY <= menuY+80 + exitGame.getHeight()) ){
			    insideExit = true;
			}
			 
			if(insideStartGame){
			  if(startGameScale < 1.05f)
			    startGameScale += scaleStep * delta;
			 
			  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){

				Azorga.currentstate = 2;
			    game.enterState(LoadConnect.ID);

			  }
			}else{
			  if(startGameScale > 1.0f)
			    startGameScale -= scaleStep * delta;
			 
			  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
			    container.exit();
			}
			 
			if(insideExit)
			{
			   if(exitGameScale < 1.05f)
				   exitGameScale +=  scaleStep * delta;
			}else{
			  if(exitGameScale > 1.0f)
				  exitGameScale -= scaleStep * delta;
			}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
