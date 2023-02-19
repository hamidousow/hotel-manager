package fr.hotelmanager.controllers;

import java.util.List;

import fr.hotelmanager.daos.RoomDAO;
import fr.hotelmanager.entities.Room;
import fr.hotelmanager.services.ServiceRoomDAO;
import fr.hotelmanager.services.ServiceRoomIMP;
import fr.hotelmanager.views.RoomView;

public class RoomController {	
	
	private RoomDAO roomDAO = new RoomDAO();
	private ServiceRoomDAO<Room> serviceRoom = new ServiceRoomIMP();
	private RoomView roomView = new RoomView();
	
	public RoomController() {
		
	}	
	
	public void createRoom() {
		Room newRoom = roomView.promptRoom();
		Room savedRoom = serviceRoom.save(newRoom);
		roomView.showNewRoom(savedRoom);
	}
	
	public void afficherEtat() {
		List <Room> listRooms = serviceRoom.findAll();		
		roomView.displayHotelState(listRooms);
	}	
	
	public void getAllRoomsByState(boolean isFree) {
		List<Room>listRooms = serviceRoom.findAllByState(isFree);
		roomView.displayAllRoomState(listRooms);
	}
	
	/*public void reserverRoom() {
		String [] auth = roomView.identification().trim().split(";");		
		boolean isAuth = roomDAO.authentification(auth);		
		roomView.resultIdentication(isAuth);
		if(!isAuth) {
			return;
		}
		int id = roomView.reserver();
		int index = serviceRoom.find(id);
		//Room room = RoomDAO.rooms.get(index);
		boolean isReserved = roomDAO.reserverRoom(id);
		//roomView.confirmeReservation(room, isReserved);
	}*/
	
	public void libererChambre() {
		String [] auth = roomView.identification().trim().split(";");		
		boolean isAuth = roomDAO.authentification(auth);		
		roomView.resultIdentication(isAuth);
		if(!isAuth) {
			return;
		}
		int id = roomView.promptId();		
		int index = serviceRoom.find(id);
		//Room room = RoomDAO.rooms.get(index);
		
		//boolean isOk = roomDAO.liberer(room);
		//roomView.confirmeLiberation(room, isOk);
		roomView.display(index);
	}

	public void chercherUneChambre() {
		int id = roomView.promptId();
		int index = serviceRoom.find(id);
		roomView.display(index);		
	}
}
