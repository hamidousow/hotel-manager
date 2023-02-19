import fr.hotelmanager.controllers.RoomController;
import fr.hotelmanager.entities.Client;
import fr.hotelmanager.entities.Room;
import fr.hotelmanager.views.AppView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HotelManager {

    public static RoomController roomController = new RoomController();

    public static List<Client> clients = new ArrayList<>();
    static Random ran = new Random();


    public static void main(String[] args) {

        while(true) {
            String choice = AppView.menuPrincipal();

            if(choice.equalsIgnoreCase("A")) {
                roomController.afficherEtat();
            }

            if(choice.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            if((choice.equalsIgnoreCase("B"))) {
                System.out.println("\n\t Chambres occupees");
                roomController.getAllRoomsByState(false);
            }

            if((choice.equalsIgnoreCase("C"))) {
                System.out.println("\n\t Chambres libres");
                roomController.getAllRoomsByState(true);
            }

            if((choice.equalsIgnoreCase("D"))) {
                System.out.println("\n\t Rechercher une chambre");
                roomController.chercherUneChambre();
            }

            if((choice.equalsIgnoreCase("E"))) {
                System.out.println("\n\t Creation d'une nouvelle chambre");
                roomController.createRoom();
            }

            /*if((choice.equalsIgnoreCase("F"))) {
                System.out.println("\n\t Reserver une chambre");
                roomController.reserverRoom();
            }*/

            if((choice.equalsIgnoreCase("G"))) {
                System.out.println("\n\t Liberer une chambre libre");
                roomController.libererChambre();
            }

            if((choice.equalsIgnoreCase("H"))) {
                //TODO
                System.out.println("\n\t Liste de clients");
                //clientController.afficherClients();
            }

            System.out.println("Appuyer sur une touche pour continuer...");
            AppView.scanner.nextLine();
        }

    }
}