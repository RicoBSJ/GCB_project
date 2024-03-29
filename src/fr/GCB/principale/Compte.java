package fr.GCB.principale;

import java.io.Serializable;
import java.util.Scanner;

public class Compte implements Serializable {
	private String typeCompte, numeroCompte;
	private double valeur;
	private int nbLigneComptaReel;
	private LigneComptable[] ligne;

	private static final int NBLigne = 10;

	public Compte() {
		Scanner lectureClavier = new Scanner(System.in);
		System.out.print("\nType du compte ");
		typeCompte = controleType();

		System.out.print("Numéro du compte : ");
		numeroCompte = lectureClavier.next();

		System.out.print("Première valeur à créditer : ");
		valeur = controleValeur();

		ligne = new LigneComptable[NBLigne];
		nbLigneComptaReel = -1;
		;
	}

	// Construteur default pour compte épargne
	public Compte(String type) {
		Scanner lectureClavier = new Scanner(System.in);
		if (type.equals("EPARGNE")) {
			this.typeCompte = type;

			System.out.print("\nNuméro du compte : ");
			numeroCompte = lectureClavier.next();

			System.out.print("Première valeur à créditer : ");
			valeur = controleValeur();

			ligne = new LigneComptable[NBLigne];
			nbLigneComptaReel = -1;
		}
	}

	public void creerLigne() {
		nbLigneComptaReel++;

		if (nbLigneComptaReel < NBLigne) {
			ligne[nbLigneComptaReel] = new LigneComptable();

		} else if (nbLigneComptaReel > NBLigne) {
			nbLigneComptaReel--;
			decalerLigne();
			ligne[nbLigneComptaReel] = new LigneComptable();
		}
		valeur += ligne[nbLigneComptaReel].getValeur();
	}

	public void afficherCompte() {
		System.out.println("\nLe compte numero " + numeroCompte + " :");
		System.out.println(" - est un compte : " + typeCompte);
		System.out.println(" - à pour actif " + valeur + " €");
		// Vérifie l'existance d'une ligne comptable et l'affiche
		if (nbLigneComptaReel >= 0) {
			for (int i = 0; i <= nbLigneComptaReel; i++)
				ligne[i].afficherLigne();
		}

	}

	// Méthodes de controle de saisie
	private String controleType() {
		Scanner lectureClavier = new Scanner(System.in);
		char tmpC;
		String tmpS = null;
		do {
			System.out.print("[(C).courant, (J).joint] : ");
			tmpC = lectureClavier.next().toUpperCase().charAt(0);

		} while (tmpC != 'C' && tmpC != 'J');

		switch (tmpC) {
		case 'C':
			tmpS = "Courant";
			break;
		case 'J':
			tmpS = "Joint";
			break;
		}

		return tmpS;
	}

	private double controleValeur() {
		Scanner lectureClavier = new Scanner(System.in);
		double tmpd;
		do {
			tmpd = lectureClavier.nextDouble();
			if (tmpd < 0)
				System.out.print("Entrez une valeur positive :");

		} while (tmpd < 0);

		return tmpd;
	}

	// Quand le nb de ligne atteint NBLigne la premiere ligne s'éfface et les
	// suivantes ce décalent pour laisser la place.
	private void decalerLigne() {
		for (int i = 1; i < NBLigne; i++) {
			ligne[i - 1] = ligne[i];
		}
	}

	//// guetteur/setteur

	public String getNumeroCompte() {
		return numeroCompte;
	}

}
