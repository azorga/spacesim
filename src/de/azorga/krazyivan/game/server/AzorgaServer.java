package de.azorga.krazyivan.game.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import de.azorga.krazyivan.game.core.entity.Entity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

public class AzorgaServer extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextArea textArea;
	JScrollPane scrollPane;
	
	public AzorgaServer(){
		super("Azorga Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane();
		
		getContentPane().add(scrollPane);
	}
	
	public static void main(String[] args) throws IOException{
		
		/**
		 * Weltraum erschaffen
		 */
		Vector<PlayerEntity> players = new Vector<PlayerEntity>();
		
		AzorgaServer as = new AzorgaServer();
		as.setVisible(true);
		
		ServerSocket serverSocket = new ServerSocket(4444);
		boolean listening = true;
		
        
		PlayerEntity player = new PlayerEntity("me", 400, 300);
        
        while(listening){
        	as.textArea.append("Waiting to connect with player: " + player  + "\n");
           new ServerThread(serverSocket.accept(), players, player, as.textArea).start();
           //playerID++;
           as.textArea.append("Players: " + players.size() + "\n");
        }

        serverSocket.close();
        System.exit(0);
		
	}
}
