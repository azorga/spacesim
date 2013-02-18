package de.azorga.krazyivan.game.client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;

import de.azorga.krazyivan.game.core.entity.Entity;
import de.azorga.krazyivan.game.core.entity.PlayerEntity;

public class ClientThread extends Thread implements Runnable{
	Socket socket;
	private Vector<PlayerEntity> players;
	int playerID;
	private Entity me;
	DataOutputStream out;
	ObjectInputStream in;
	boolean loop = true;

	public ClientThread(String ip){
		super("ClientThread");
		try{
			players = new Vector<PlayerEntity>();
	         socket = new Socket(ip, 4444);
	         socket.setTcpNoDelay(true);
	         out = new DataOutputStream(socket.getOutputStream());
	         in = new ObjectInputStream(socket.getInputStream());
	         playerID = in.readInt();
	         players = (Vector<PlayerEntity>) in.readObject();
	         
	         if(players != null)
	            System.out.println("Not Null: " + players.size());
	         
	         boolean b = false;
	         for(int i = 0; i < players.size(); i++){
	            if(!b){
	               if(players.get(i).getId().equals(playerID)){
	                  me = players.get(i);
	                  b = true;
	               }
	            }
	         }
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public Entity getMe() {
		return me;
	}

	public void setMe(Entity me) {
		this.me = me;
	}

	public Vector<PlayerEntity> getPlayers() {
		return players;
	}

	public void setPlayers(Vector<PlayerEntity> players) {
		this.players = players;
	}
	public void run(){
	      try{
	         while(loop){
	            try{
	               if(!socket.isClosed() && socket.isConnected()){
	                    out.writeInt((int)me.getPosition().x);
	                    out.writeInt((int)me.getPosition().y);
	                    out.flush();
	                    
	                    //players = new Vector<Player>();
	                    players = (Vector<PlayerEntity>) in.readObject();
	                    
	                    System.out.println("size" + players.size());
	                    sleep(15);
	               }
	               
	               else
	                  loop = false;
	            
	              }
	            catch(Exception e){
	                   e.printStackTrace();
	                   socket.close();
	             }  
	         }
	         
	         
	         
	      }
	      
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	 
	         
	         
	      
	      
}
