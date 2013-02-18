package de.azorga.krazyivan.game.tools;

import java.util.ArrayList;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;

public class MusicLoader {
	public static ArrayList<Music> loadMusic(MusicListener listener) throws SlickException{
		ArrayList<Music> tracklist = new ArrayList<Music>();
		Music track1 = new Music("resources/music/ambient1.wav");
		track1.addListener(listener);
		Music track2 = new Music("resources/music/ambient2.wav");
		track2.addListener(listener);
		Music track3 = new Music("resources/music/ambient3.wav");
		track3.addListener(listener);
		Music track4 = new Music("resources/music/ambient4.wav");
		track4.addListener(listener);
		Music track5 = new Music("resources/music/ambient5.wav");
		track5.addListener(listener);
		Music track6 = new Music("resources/music/ambient6.wav");
		track6.addListener(listener);
		Music track7 = new Music("resources/music/ambient7.wav");
		track7.addListener(listener);
		Music track8 = new Music("resources/music/ambient8.wav");
		track8.addListener(listener);
		Music track9 = new Music("resources/music/ambient9.wav");
		track9.addListener(listener);
		Music track10 = new Music("resources/music/ambient10.wav");
		track10.addListener(listener);
		Music track11= new Music("resources/music/ambient11.wav");
		track11.addListener(listener);
		Music track12 = new Music("resources/music/ambient12.wav");
		track12.addListener(listener);
		Music track13 = new Music("resources/music/ambient13.wav");
		track13.addListener(listener);
		Music track14 = new Music("resources/music/ambient14.wav");
		track14.addListener(listener);
		Music track15 = new Music("resources/music/ambient15.wav");
		track15.addListener(listener);
		Music track16 = new Music("resources/music/ambient16.wav");
		track16.addListener(listener);
		Music track17 = new Music("resources/music/ambient17.wav");
		track17.addListener(listener);
		Music track18 = new Music("resources/music/ambient18.wav");
		track18.addListener(listener);
		Music track19 = new Music("resources/music/ambient19.wav");
		track19.addListener(listener);
		tracklist.add(track1);
		tracklist.add(track2);
		tracklist.add(track3);
		tracklist.add(track4);
		tracklist.add(track5);
		tracklist.add(track6);
		tracklist.add(track7);
		tracklist.add(track8);
		tracklist.add(track9);
		tracklist.add(track10);
		tracklist.add(track11);
		tracklist.add(track12);
		tracklist.add(track13);
		tracklist.add(track14);
		tracklist.add(track15);
		tracklist.add(track16);
		tracklist.add(track17);
		tracklist.add(track18);
		tracklist.add(track19);
		return tracklist;
	}
}
