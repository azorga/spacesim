package de.azorga.krazyivan.game.tools;

import javax.naming.NameNotFoundException;
import javax.naming.spi.DirStateFactory.Result;
/**
 * Klasse fuer zufaelliges Erzeugen von Namen. Koennte aber auf dauer noch optimiert werden,
 * ggf. die Namen in externe Ressourcenlisten (csv?)
 * 
 * 
 * @author andreas
 *
 */
public class RandomNameGenerator {
	static String[] namenssilben = {"do","doo","de","dee","mi","mii","mie","mei","sha","ka","ree","re","spo","kri","ki",
						"be","bee","ce","cee", "la", "laa","ka","kaa","ca","caa", "mi","ve","ga","vee","gaa", "vi",
						"vii", "bo", "boo", "fa", "shi", "xi", "xii", "ras", "raas", "ra","raa", "ro", "rho", "tau", "is", "wix",
						"ti", "tir","ka", "kaa", "laaa", "lo"};
	
	static String[] sternnamen = {"Delta", "Gamma", "Epsilon", "Indi", "Beta", "Alpha", "Piscium", "Wolf", "Cygnus", "Cygnii", "LV", "HG",
						"AM", "TM", "AT", "RC", "NCC", "Aldebaraan"};
	
	static String[] sternappendix = {"P", "Q", "R", "S", "N", "L", "DD", "D"};
	
	static String[] festnamen = {"Vulkan", "Bootis", "Capella", "Tharkad", "Maxwell", "Gibson", "Marik", "Oberon", "Skye", "Avalon",
							"Beteigeuze", "Denebola", "Radstadt", "Star´s End", "Kestrel", "Dahar", "Kessel", "Rashalaag",
							"Kronos", "Berlin", "Tukayyid", "Thule", "Luthien", "Endor", "Andor", "Terok Nor", "Satander",
							"Caladan", "Iegi", "Ix", "Sarmakand", "Deneb", "Cologne", "Nimbus", "Neg'var", "Be'hrel", "Tokyo", "Anbus", "Buzzel",
							"Bela Tegeuse", "Chusuk", "Corrin", "Ecaz", "Ginaz", "Gamont", "Grumman", "Wallach", "Tleilax", "Akka", "Jubbul",
							"Klendathu", "P", "Sanctuary", "Haven", "Aiur", "Char", "Mar Sara", "Tarsonis", "Chau Sara", "Khoral", "Hamburg",
							"Darwin", "Hell", "Chiron", "Botany", "Gor", "Ishtar", "Mongo", "Terra Nova", "Nirn", "Pandora", "Pyrrus", "Pern",
							"Halo", "Rylos", "Thundera", "Gieedi Prime","Gaea",  "Onyx", "Babel", "Babylon", "Ferenginar", "Praxis", "Remus",
							"Khitomer", "Benzar", "Betazed", "Sarpeidon", "Pollux" };
	
	static String[] starbasenamen = {"Deep Space", "Deep", "K", "Raumbasis", "Starbase", "Station", "Orbitalstation", "Hope", "Final Frontier", "Cargo"};
	
	static String[] piratenbasenamen = {"Terror", "Claw", "Dark nest", "Pirate Bay", "Last Hope"};
	
	static String[] romannumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "IX", "X"};
	
	public static String getRandomPlanetName(){
		String result = "";
		//Zufällig festlegen ob name aus silben oder festnamen erzeugt werden soll
		if (myRandom(0,1)==1){
			//Verwende Namenssilben
			//Wieviele Silben sollen verwendet werden?
			if(myRandom(0,1)==1){
				result+=namenssilben[myRandom(0, namenssilben.length-1)];		
				result+=namenssilben[myRandom(0, namenssilben.length-1)];
			}else{
				result+=namenssilben[myRandom(0, namenssilben.length-1)];
				result+=namenssilben[myRandom(0, namenssilben.length-1)];
				result+=namenssilben[myRandom(0, namenssilben.length-1)];
			}
		}else{
			//festnamen
			result+=festnamen[myRandom(0, festnamen.length-1)];
		}
		//Soll eine Zufallszahl dahintergehängt werden oder eine zufällige römische zahl?
		if(myRandom(0,1)==1){
			result+= " ";
			result+=String.valueOf(myRandom(5, 1701));
		}else{
			result+= " ";
			result+=romannumbers[myRandom(0, romannumbers.length-1)];
		}
		return result;
	}
	
	public static String getRandomStarName(){
		String result = "";
		result.concat(sternnamen[myRandom(0, sternnamen.length-1)]);
		//Soll eine Zufallszahl dahintergehängt werden oder eine zufällige römische zahl?
		if(myRandom(0,1)==1){
			result+= " ";
			result.concat(String.valueOf(myRandom(5, 1701)));
		}else{
			result+= " ";
			result.concat(romannumbers[myRandom(0, romannumbers.length-1)]);
		}
		result.concat(sternappendix[myRandom(0, sternappendix.length-1)]);
		return result;
	}
	
	public static String getRandomStarbaseName(){
		String result = "";
		result+=(starbasenamen[myRandom(0, starbasenamen.length-1)]);
		//Soll eine Zufallszahl dahintergehängt werden oder eine zufällige römische zahl?
		if(myRandom(0,1)==1){
			result+= " ";
			result+=(String.valueOf(myRandom(5, 1701)));
		}else{
			result+= " ";
			result+=(romannumbers[myRandom(0, romannumbers.length-1)]);
		}
		return result;
	}
	
	public static String getRandomPirateStarbaseName(){
		return null;
	}
	
	private static int myRandom(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}		

	
	
	
}
