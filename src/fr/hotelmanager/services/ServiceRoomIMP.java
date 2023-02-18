package fr.hotelmanager.services;

import java.util.List;
import java.util.Random;

import fr.hotelmanager.daos.RoomDAO;
import fr.hotelmanager.entities.Room;

public class ServiceRoomIMP implements ServiceDAO<Room> {
	
	Random ran = new Random();


	@Override
	public Room save(Room newRoom) {
		RoomDAO.rooms.add(newRoom);
		return newRoom;
	}
	
	@Override
	public int find(int id) {
		List<Room> list = findAll();
		
		for(Room room : list) {
			if(id == (room.getId())) {
				return list.indexOf(room);
			}			
		}
		return -1;			
	}
	
	@Override
	public List<Room> findAll() {				
		return RoomDAO.rooms;
	}
	
	@Override
	public boolean update(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Room delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
