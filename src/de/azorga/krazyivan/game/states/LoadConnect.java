package de.azorga.krazyivan.game.states;


import javax.swing.JOptionPane;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.azorga.krazyivan.game.main.Azorga;






public class LoadConnect extends BasicGameState{
	/**
	 * Gamestate ID
	 */
	public static final int ID = 2;

	private boolean connected = false;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

		


	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		if(Azorga.currentstate == 2){
			connect();
			login();
			if(connected){
				MainMenu.music.fade(2000, 0, true);
				game.enterState(AzorgaGame.ID);			
			}
		}


	}

	private void login() {
		AzorgaGame.playername = JOptionPane.showInputDialog("Ihr Name");
	}

	private void connect() {
		//String ip = JOptionPane.showInputDialog("IP-Adresse des Servers");
		AzorgaGame.server_ip = null;
		connected = true;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}



}
