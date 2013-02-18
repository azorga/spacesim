package de.azorga.krazyivan.game.server;

import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

import de.azorga.krazyivan.game.core.entity.Entity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

public class ServerThread extends Thread implements Runnable{
	Socket acceptedSocket;
	JTextArea textArea;
	Vector<PlayerEntity> players;
	Vector<Entity> planets;
	Vector<Entity> stars;
	Vector<Entity> asteroids;
	Vector<Entity> lasers;
	Vector<Entity> starbases;
	
	
	public ServerThread(Socket acceptedSocket, Vector<PlayerEntity> players, PlayerEntity player, JTextArea textArea){
		super("ServerThread");
		this.acceptedSocket = acceptedSocket;
		this.players = players;
		players.add(player);
		
	}
}
