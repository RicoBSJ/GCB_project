package fr.GCB.principale;

import java.util.Scanner;

public class Projet {
	
	public static void main(String[] args) {
		byte choix;	
		String tmp,	vide ="";
		char tmpC;
		
		Scanner lectureClavier = new Scanner(System.in);
		
		Compte C = new Compte(vide);

		do{
			choix = menuPrincipale();		
			switch (choix){
			
				case 1 :
					System.out.print("\nVoulez vous créez un compte épargne ? (o/n) : ");	
					tmpC = lectureClavier.next().charAt(0);
					if(tmpC == 'o') C = new CompteEpargne();
					else C = new Compte();
					break;
				
				case 2 :
					System.out.println("\n***** 2.AFFIHCER UN COMPTE *****\n");
					C.afficherCmpte();											
					break;
				
				case 3 :
					System.out.println("\n***** 3.CREER UNE LIGNE COMPTABLE *****\n");				
					System.out.print("Veuillez saisir un numéro de compte : ");
					tmp = lectureClavier.nextLine();
					if(tmp.equals(C.getNumeroCompte())){ 
						C.creerLigne();
					}else{ 
						System.out.println("\n*** Ce compte n'éxiste pas ! ***");
					}
					break;
				
				case 4 :
					System.out.println("\n***** 4.SORTIR *****\n");
					sortir();
					break;
				
				case 5:
					System.out.println("\n***** DE L'AIDE *****");
					alAide();
					break;
				
				default :
					System.out.println("\nVous n'avez pas fait un choix entre 1 et 5 !\n");
			}
				
		}while(!(choix == 4));
		
		System.out.println("\nA bientot !");
	}
	
	//Menu principale, case 4 et 5.
	
	public static byte menuPrincipale(){
		byte tmp;
		Scanner lectureClavier = new Scanner(System.in);
		
		System.out.println("\n***** MENU ***** \n");
		System.out.println("1. Créer un compte");
		System.out.println("2. Afficher un compte");
		System.out.println("3. Créer une ligne comptable");
		System.out.println("4. Sortir");
		System.out.println("5. De l'aide");
		System.out.print("\nVotre choix : ");
		
		tmp = lectureClavier.nextByte();
		
		return tmp;
	}
		
	public static void sortir(){
		System.out.println("A bientôt");
		System.exit(0) ;   
	}
		
	public static void alAide(){
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
	}	
}
	
	
	
	