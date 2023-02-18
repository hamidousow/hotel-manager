package fr.hotelmanager.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.hotelmanager.entities.Room;
import fr.hotelmanager.services.ServiceDAO;
import fr.hotelmanager.services.ServiceRoomIMP;


public class RoomDAO {	
	
	private ServiceDAO<Room> serviceRoom = new ServiceRoomIMP();
	public static List<Room> rooms = new ArrayList();
	
	public RoomDAO() {
		
	}		
	
	public List<Room> findAllRoomsByState(boolean isFree) {
		List<Room>listRooms = serviceRoom.findAll();		
		List <Room> listRoomsByState = new ArrayList<>();	
		
		for(Room room : listRooms) {
			if(room.isFree() == isFree) {
				listRoomsByState.add(new Room(room.isFree(), room.getNbrLits(), room.getNbrPlaces()));
			}			
		}
		return listRoomsByState;
	}	
	
	public boolean authentification(String [] auth) {
		
		String login = auth[0];
		String password = auth[1];
		
		if(!(login.equals("login") && password.equals("password"))) {			
			return false;
		}
		
		return true;
	}

	public boolean reserverRoom(int id) {
		List<Room>list = findAllRoomsByState(true);
		int indexRoom = serviceRoom.find(id);
		list.get(indexRoom).setIsFree(false);
		return true;		
	}
	
	public boolean liberer(Room room) {
		if(room.isFree()) {
			return false;
		}		
		room.setIsFree(true);		
		return true;
	}
}
