package de.azorga.krazyivan.game.core.entity;

/**
 * 
 * Klasse mit sich nicht bewegenden Entitäten
 * 
 * @author andreas
 *
 */
public class FixEntity extends Entity {

	String bezeichnung = null;
	
	public FixEntity(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public void setBezeichnung(String bezeichnung){
		this.bezeichnung = bezeichnung;
	}
	
	public String getBezeichnung(){
		return this.bezeichnung;
	}

}
