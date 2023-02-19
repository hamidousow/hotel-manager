package fr.hotelmanager.entities;

public class Room {
	
	private int id;
	public static int cpt = 0;
	private boolean isFree;
	private String name;
	private int nbrLits;
	private int nbrPlaces;
	
	public Room() {
		
	}
	
	public Room(int id) {
		this.id = id;
	}

	public Room(int id, String name, boolean isFree, int nbrLits, int nbrPlaces) {
		this.id = id;
		this.name = name;
		this.isFree = isFree;
		this.nbrLits = nbrLits;
		this.nbrPlaces = nbrPlaces;
	}

	public Room(boolean isFree, int nbrLits, int nbrPlaces) {
		this.id = ++cpt;
		this.isFree = isFree;
		this.nbrLits = nbrLits;
		this.nbrPlaces = nbrPlaces;
	}
	
	public Room(int id, boolean isFree) {
		this.id = id;
		this.isFree = isFree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		
		this.isFree = isFree;
	}

	public int getNbrLits() {
		return nbrLits;
	}

	public void setNbrLits(int nbrLits) {
		this.nbrLits = nbrLits;
	}

	public int getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}	
	
	public String toString() {
		return "Id : " + this.id + "\n Disponibilite : " + isFree() + "\n Nombre de places : " + getNbrPlaces() +"\n Nombre de lits : " + getNbrLits();
	}

}
