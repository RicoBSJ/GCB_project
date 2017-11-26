package fr.GCB.principale;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long numeroCompte = 0;
		//String theme, moyenPaiement;
		Double valeur = 0.0d;
		float taux = 0;
		Date date;
		char typeCompte = ' ', saisieNew;
		byte choix;
		
		Scanner lectureClavier = new Scanner(System.in);
		
		do{

			System.out.println("\n***** MENU ***** \n");
			System.out.println("1. Créer un compte");
			System.out.println("2. Afficher un compte");
			System.out.println("3. Creer une ligne comptable");
			System.out.println("4. Sortir");
			System.out.println("5. De l'aide");
			System.out.print("\nVotre choix : ");
			choix = lectureClavier.nextByte();
			switch (choix){
			
				case 1 :
					 do { 
						System.out.print("\nType du compte [Types possibles :" ); 
						System.out.print("C(ourant), J(oint), E(pargne)] :");
						typeCompte = lectureClavier.next().toLowerCase().charAt(0);
					 } while ( typeCompte != 'c' && typeCompte != 'j' && typeCompte != 'e');
					
						System.out.print("\nNuméro du compte : ");
						numeroCompte = lectureClavier.nextLong();
						System.out.print("Première valeur créditée : ");
						valeur = lectureClavier.nextDouble();						
					 if ( typeCompte == 'e'){
						System.out.print("Taux de placement : ");
						taux = lectureClavier.nextFloat();	
					 }
					break;
				
				case 2 :
					System.out.println("\n***** 2.AFFIHCER UN COMPTE *****\n");
					System.out.print("\nSaissisez le numéro du compte : ");
					long compte = lectureClavier.nextLong();
								
					if(compte == numeroCompte)
						System.out.println("\nLe compte numero : " + numeroCompte
								+ "\n- est un compte : " + typeCompte
								+ "\n- à pour actif " + valeur + " €"
								+ "\n- à un taux de : " + taux +" %");		
						
					else 
						System.out.println("\nCe compte n'existe pas !");
					
						
					break;
				
				case 3 :
					System.out.println("\n***** 3.CREER UNE LIGNE COMPTABLE *****\n");
					System.out.println("Option non programmée.");
					break;
				
				case 4 :
					System.out.println("\n***** 4.SORTIR *****\n");
					System.out.println("A bientôt");
					System.exit(0) ;  
					break;
				
				case 5:
					System.out.println("\n***** DE L'AIDE *****");
					System.out.println("Option 1 : Pour créer un compte Courant entrer C ");
					System.out.println("           Pour créer un compte Joint entrer J ");
					System.out.println("           Pour créer un compte Epargne entrer E");
					System.out.print("           Puis, entrer le numero du compte, et"); 
					System.out.println(" sa premiere valeur créditée ");
					System.out.println("          Dans le cas d'un compte épargne, entrer le taux ");
					System.out.println("Option 2. Le systeme affiche les données du compte choisi ");
					System.out.println("Option 3. Ecrire une ligne comptable");
					System.out.println("Option 4. Pour quitter le programme");
					System.out.println("Option 5. Pour afficher de l'aide");
					break;
				
				default :
					System.out.println("\nVous n'avez pas fait un choix entre 1 et 5 !\n");
			}
				
		}while(!(choix == 4));
		
		System.out.println("\nA bientot !");
	}


	
}
	
	
	
	