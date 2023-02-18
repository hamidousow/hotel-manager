package fr.hotelmanager.views;

import java.util.List;

import fr.hotelmanager.daos.RoomDAO;
import fr.hotelmanager.entities.Room;

public class RoomView {
	
	public AppView appView;
	
	public RoomView() {
		
	}
	
	public void displayHotelState(List <Room> list) {
		int totalFreeRooms = 0;
		int	totalBusyRooms = 0;	
		
		for(Room room : list) {
			if(room.isFree()) {
				totalFreeRooms++;
			} else if(!room.isFree()) {
				totalBusyRooms++;
			}				 
		}		
		
		System.out.println("Total des chambres : " + list.size());
		System.out.println();
		System.out.println("Total chambre libres : " + totalFreeRooms);
		System.out.println("Total chambre occupees : " + totalBusyRooms);
	}
	
	public void displayAllRoomState(List <Room> list) {
		String etat = "";
		int total = 0;
		for(Room room : list) {
			total++;
			if(room.isFree()) {
				etat = "Libre";
			} else {
				etat = "Occupee";
			}
			System.out.println("\tNumero de chambre : "+ room.getId() + "\n\t" + "Etat : " + etat);
			System.out.println();
			
		}	
		System.out.println();
		System.out.println("Total chambre : " + total);
		System.out.println();		
	}

	public void display(int index) {
		/*if(room==null) {
			System.out.println("Aucune chambre correspond a cet ID.");
			return;
		}*/
		System.out.println(RoomDAO.rooms.get(index));
	}
	
	public String identification() {
		
		String saisieLogin = "";
		String saisiePassword = "";	
		
		System.out.print("Saisir le login : ");
		saisieLogin = appView.scanner.nextLine();
		System.out.print("Saisir le mot de passe : ");
		saisiePassword = appView.scanner.nextLine();
		return saisieLogin +";"+saisiePassword;		
	}
	
	public boolean resultIdentication(boolean isAuth) {
		
		if(isAuth) {
			System.out.println("Connexion reussi");
			return true;		
		}			
			
		System.out.println("Login ou mot de passe incorrect");	
		return false;		
	}
	
	public boolean retryIdentication() {
		
		String choice = "";		
		System.out.println("[O] pour reesayer");
		System.out.println("Appuyer sur une autre touche pour retourner au menu principal");
		choice = appView.scanner.nextLine().trim();
		
		if("O".equalsIgnoreCase(choice)) {
			return true;
		}
		
		return false;
	}

	public void confirmation(Room room) {
		System.out.println("La chambre " + room.getId() + " a ete reservee.");		
	}
	
	public int promptId() {		
		System.out.print("Saisir l'ID de la chambre : ");
		int id = Integer.parseInt(appView.scanner.nextLine().trim());
		return id;
	}
	
	public void confirmeLiberation(Room room, boolean isOk) {	
		if(!isOk) {
			System.out.print("L'operation a echouee");
			return; 
		}
		
		System.out.println("La chambre " + room.getId() + " a ete liberee.");	
	}
	
	public void confirmeReservation(Room room, boolean isReserved) {
		if(!isReserved) {
			System.out.print("L'operation a echouee");
			return; 
		}
		System.out.println("La chambre " + room.getId() + " a ete reservee.");
	}

	public Room promptRoom() {
		System.out.print("Saisir le nombre de lit : ");
		int nbrLits = Integer.parseInt(appView.scanner.nextLine().trim());
		System.out.print("Saisir le nombre de place : ");
		int nbrPlaces = Integer.parseInt(appView.scanner.nextLine().trim());
		
		return new Room(true, nbrLits, nbrPlaces);
		
	}
	
	public void showNewRoom(Room newRoom) {
		System.out.println("Nouvelle chambre "+ newRoom.getId() + " a ete ajoutee avec succes.");
	}
	
	public int reserver() {
		System.out.print("Saisir l'ID de la chambre a reserver : ");
		int id = Integer.parseInt(appView.scanner.nextLine());
		return id;
	}

	
}
