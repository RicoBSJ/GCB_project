package fr.GCB.principale;

import java.util.Scanner;

public class Projet {

	public static void main(String[] args) {
		byte choix;
		String numLu;

		Scanner lectureClavier = new Scanner(System.in);

		ListeCompte listeCompte = new ListeCompte();
		/**
		 * Une lecture automatique du fichier Compte.dat dès l’ouverture du
		 * programme afin d’initialiser l’objet listeCompte à la liste de
		 * compte saisie lors d’une précédente exécution.
		 */
		FichierCompte F = new FichierCompte();
		if (F.ouvrir("L")) {
			listeCompte = F.lire();// ?
			F.fermer();
		}

		do {
			choix = menuPrincipale();
			switch (choix) {

			case 1:
				System.out.println("\n***** 1.CREER UN COMPTE *****");
				System.out.print("\nQuelle type de compte voulez vous crée épargne ou autre ? : ");
				String type = lectureClavier.next().replace("é", "e").toUpperCase();
				listeCompte.ajouteCompte(type);
				break;
			case 2:
				System.out.println("\n***** 2.AFFIHCER UN COMPTE *****");
				System.out.print("\nSaissisez le numéro du compte : ");
				numLu = lectureClavier.next();
				listeCompte.rechercherUnCompte(numLu);
				break;
			case 3:
				System.out.println("\n***** 3.CREER UNE LIGNE COMPTABLE *****");
				System.out.print("\nVeuillez saisir votre numéro de compte : ");
				numLu = lectureClavier.next();
				listeCompte.ajouterUneLigne(numLu);
				break;
			case 4:
				System.out.println("\n***** 4.SUPPRIMER UN COMPTE *****");
				System.out.print("\nEntrez le numéro du compte que vous souhaitez supprimer : ");
				numLu = lectureClavier.next();
				listeCompte.supprimeUnCompte(numLu);
				break;
			case 5:
				System.out.println("\n***** 5.Liste des comptes *****");
				listeCompte.afficherLesCompte();
				break;
			case 6:
				System.out.println("\n***** 6.DE L'AIDE *****");
				alAide();
				break;
			case 7:
				System.out.println("\n***** 7.SORTIR *****\n");
				System.out.println("Sauvegarde des données dans Cursus.dat");
				F.ouvrir("Ecriture");
				F.ecrire(listeCompte);
				F.fermer();
				System.exit(0);
				break;

			default:
				System.out.println("\nVous n'avez pas fait un choix entre 1 et 7 !\n");
			}

		} while (!(choix == 7));

		System.out.println("\nA bientot !");
	}

	// Menu principale, case 4 et 5.
	public static byte menuPrincipale() {
		byte tmp;
		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("\n***** MENU ***** \n");
		System.out.println("1. Créer un compte");
		System.out.println("2. Afficher un compte");
		System.out.println("3. Créer une ligne comptable");
		System.out.println("4. Supprimer un compte");
		System.out.println("5. Afficher la liste des comptes");
		System.out.println("6. De l'aide");
		System.out.println("7. Sortir");
		System.out.print("\nVotre choix : ");

		tmp = lectureClavier.nextByte();

		return tmp;
	}

	public static void sortir() {
		System.out.println("A bientôt");
		System.exit(0);
	}

	public static void alAide() {
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
