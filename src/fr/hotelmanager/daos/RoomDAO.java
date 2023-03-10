package fr.hotelmanager.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.hotelmanager.entities.Room;
import fr.hotelmanager.utils.DatabaseConnection;


public class RoomDAO {	

	Connection connection;
	Statement st = null;
	
	public RoomDAO() {
		this.connection = DatabaseConnection.getInstance().getCOnnection();
	}

	public List<Room> findAll() {
		List<Room> rooms = new ArrayList<>();

		try {
			String query = "SELECT * FROM rooms;";
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Room room = new Room(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getBoolean(5)
				);
				rooms.add(room);
			}
			return rooms;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}/* finally {
			if(st != null) {
				closeStatement();
			}
			if(connection != null) {
				closeConnection();
			}
		}*/
	}

	public List<Room> findAllRoomsByState(boolean isFree) {
		List<Room>listRooms = findAll();
		List <Room> listRoomsByState = new ArrayList<>();

		for(Room room : listRooms) {
			if(room.isFree() == isFree) {
				listRoomsByState.add(
						new Room(
								room.getId(),
								room.getName(),
								room.getNbrLits(),
								room.getNbrPlaces(),
								room.isFree()
						)
				);
			}
		}
		return listRoomsByState;
	}

	/*public boolean reserverRoom(int id) {
		List<Room>list = findAllRoomsByState(true);
		int indexRoom = serviceRoom.find(id);
		list.get(indexRoom).setIsFree(false);
		return true;
	}*/

	/*public void reserver(int id) {
		List<Room>list = findAllRoomsByState(true);
		int indexRoom = serviceRoom.find(id);
		list.get(indexRoom).setIsFree(false);
	}*/

	public boolean liberer(Room room) {
		if(room.isFree()) {
			return false;
		}
		room.setIsFree(true);
		return true;
	}

	public boolean authentification(String [] auth) {

		String login = auth[0];
		String password = auth[1];

		if(!(login.equals("login") && password.equals("password"))) {
			return false;
		}

		return true;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void closeStatement() {
		try {
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
