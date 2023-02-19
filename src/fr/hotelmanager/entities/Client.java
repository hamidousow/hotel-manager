package fr.hotelmanager.entities;

public class Client {
	
	private int id;
	private static int cpt = 0;
	private String firstname;
	private String lastname;
	private String mail;
	
	public Client() {
		
	}
	
	public Client(String firstname, String lastname, String mail) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString() {
		return "id = " + id + "\n" +
				", nom = " + this.firstname + ", prenom = " + this.lastname + "\n" +
				", mail = " + mail;
	}
}
