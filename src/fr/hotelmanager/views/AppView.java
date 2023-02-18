package fr.hotelmanager.views;

import java.util.Scanner;

public class AppView {
	
	public static Scanner scanner = new Scanner(System.in);
	private static AppView instance;
	
	private AppView() {
		super();
	}
	
	public static AppView getInstance() {
		if(instance == null) 
			instance = new AppView();
		return instance;
	}
	
	public static String menuPrincipal() {
		
		System.out.println("\t\t --- Menu Hotel ---\t\t");
		System.out.println();
		System.out.println("\t [A] - Afficher l'etat de l'hotel");
		System.out.println("\t [B] - Afficher le nombre de chambres occupees");
		System.out.println("\t [C] - Afficher le nombre de chambres libres");
		System.out.println("\t [D] - Rechercher une chambre");
		System.out.println("\t [E] - Creer une nouvelle chambre");		
		System.out.println("\t [F] - Reserver une chambre");
		System.out.println("\t [G] - Liberer une chambre libre");
		System.out.println();
		System.out.println("\t [H] - Afficher tous les clients");
		System.out.println();
		System.out.println("\t [Q] - Quitter l'application \t");
		System.out.println();
		System.out.print("Choix menu : ");
		
		return AppView.scanner.nextLine().trim();
	}

}
