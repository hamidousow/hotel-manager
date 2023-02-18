package fr.hotelmanager.entities;

public class Client {
	
	private int id;
	private static int cpt = 0;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String mail;
	
	public Client() {
		
	}
	
	public Client(String nom, String prenom, String dateNaissance, String mail) {
		this.id = ++cpt;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString() {
		return "Client [id = " + id + ", nom = " + nom + ", prenom = " + prenom + ", date de naissance = " + dateNaissance
				+ ", mail = " + mail + "]";
	}
}
