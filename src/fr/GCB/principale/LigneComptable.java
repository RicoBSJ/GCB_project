package fr.GCB.principale;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class LigneComptable implements Serializable {

	private String motif, modePaiement;
	private double valeur = 0.0d;
	private LocalDate dateLigne;

	public LigneComptable() {
		Scanner lectureClavier = new Scanner(System.in);
		// Récupere la date
		dateLigne = LocalDate.now();

		System.out.print("La somme à créditer (+) ou à débiter (-) : ");
		valeur = lectureClavier.nextInt();

		System.out.print("Le motif ");
		motif = controleMotif();

		System.out.print("Le mode ");
		modePaiement = controleModePaiement();
	}

	public void afficherLigne() {
		System.out.println("\nEn date du " + dateLigne);
		if (valeur > 0)
			System.out.println("- Montant créditer : " + valeur + "€");
		else {
			System.out.println("- Montant débiter : " + valeur + "€");
			System.out.println("- Motif : " + motif);
			System.out.println("- Mode de paiement : " + modePaiement);
		}
	}

	// Méthodes controle de saisie
	private String controleMotif() {
		Scanner lectureClavier = new Scanner(System.in);
		char tmpC;
		String tmpS = null;
		do {
			System.out.print("[(S).salaire, (L).loyer, (A).Alimentation, (D).divers] : ");
			tmpC = lectureClavier.next().toUpperCase().charAt(0);

		} while (tmpC != 'S' && tmpC != 'L' && tmpC != 'A' && tmpC != 'D');

		switch (tmpC) {
		case 'S':
			tmpS = "Salaire";
			break;
		case 'L':
			tmpS = "Loyer";
			break;
		case 'A':
			tmpS = "Alimentation";
			break;
		case 'D':
			tmpS = "Divers";
			break;
		}
		return tmpS;
	}

	private String controleModePaiement() {
		Scanner lectureClavier = new Scanner(System.in);
		char tmpC;
		String tmpS = null;
		do {
			System.out.print("[(C).CB, (Q).chèque, (V).virement] : ");
			tmpC = lectureClavier.next().toUpperCase().charAt(0);

		} while (tmpC != 'C' && tmpC != 'Q' && tmpC != 'V');

		switch (tmpC) {
		case 'C':
			tmpS = "CB";
			break;
		case 'Q':
			tmpS = "chèque";
			break;
		case 'V':
			tmpS = "virement";
			break;
		}

		return tmpS;
	}

	// getter/setter
	public double getValeur() {
		return valeur;
	}

}