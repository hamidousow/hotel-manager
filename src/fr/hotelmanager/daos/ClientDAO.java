package fr.hotelmanager.daos;

import fr.hotelmanager.entities.Client;
import fr.hotelmanager.services.ServiceRoomDAO;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
	
	List<Client> clients =  new ArrayList<>();
	
	public ClientDAO() {
		
	}

	public Client save(Client client) {
		clients.add(client);
		return client;
	}


	public int find(int id) {
		for(Client client : clients) {
			if(id==(client.getId())) {
				return clients.indexOf(client);
			}			
		}
		return -1;
	}

	public List<Client> findAll() {		
		return clients;
	}

	public boolean update(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Client delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
