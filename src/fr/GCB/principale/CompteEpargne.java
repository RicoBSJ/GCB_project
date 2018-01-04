package fr.GCB.principale;

import java.io.Serializable;
import java.util.Scanner;

public class CompteEpargne extends Compte implements Serializable {
	private double taux;

	public CompteEpargne() {
		super("EPARGNE");
		taux = controleTaux();
	}

	public void afficherCompte() {
		super.afficherCompte();
		System.out.println(" - Taux : " + taux);
	}

	// Methode controle de saisi
	public double controleTaux() {
		Scanner lectureClavier = new Scanner(System.in);
		double tmpd;
		do {
			System.out.print("Taux de placement : ");
			tmpd = lectureClavier.nextDouble();
			if (tmpd < 0)
				System.out.print("Entrez un taux positif :");

		} while (tmpd < 0);

		return tmpd;
	}

	public double getTaux() {
		return taux;
	}

}