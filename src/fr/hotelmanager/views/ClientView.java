package fr.hotelmanager.views;

import java.util.List;
import fr.hotelmanager.entities.Client;

public class ClientView {
	
	private static ClientView instance;
	
	private ClientView() {
		
	}

	public static ClientView getInstance() {
		if(instance==null) 
			instance = new ClientView();
		
		return instance;
	}

	public void displayClients(List<Client> clients) {
		for(Client client : clients) {
			System.out.println(client.toString());
		}
		
	}

}
