package fr.hotelmanager.daos;

import fr.hotelmanager.entities.Client;
import fr.hotelmanager.services.ServiceDAO;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements ServiceDAO<Client> {
	
	List<Client> clients =  new ArrayList<>();
	
	public ClientDAO() {
		
	}

	@Override
	public Client save(Client client) {
		clients.add(client);
		return client;
	}

	@Override
	public int find(int id) {
		for(Client client : clients) {
			if(id==(client.getId())) {
				return clients.indexOf(client);
			}			
		}
		return -1;
	}

	@Override
	public List<Client> findAll() {		
		return clients;
	}

	@Override
	public boolean update(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
