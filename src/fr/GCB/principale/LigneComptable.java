package fr.GCB.principale;

import java.util.Scanner;

public class LigneComptable {
		
	private String motif, modePaiement, date;
	private double valeur = 0.0d;
	
	Scanner lectureClavier = new Scanner(System.in);
	
	public void creerLigneComptable(){
		System.out.println("Indiquez le numéro du compte : ");
		
		
		System.out.print("La somme à créditer (+) ou à débiter (-) : ");
		valeur = lectureClavier.nextInt();
		
		System.out.print("La date de l'opération (dd/mm/yyyy) : ");
		date = lectureClavier.next();
		
		System.out.print("Le motif ");
		motif = controleMotif();
		
		System.out.print("Le mode ");
		modePaiement = controleModePaiement();
		
	}
	
	public void afficherLigne(){		
		System.out.println("\nEn date du : " + date);
		if(valeur > 0) System.out.println("- Montant créditer : " + valeur + "€");
		else System.out.println("- Montant débiter : " +valeur+ "€");
		System.out.println("- Motif : " + motif);
		System.out.println("- Mode de paiement : " + modePaiement);	
	}
	
	//Méthodes controle de saisie
	private String controleMotif(){
		char tmpC;
		String tmpS = null;
		do { 
			System.out.print("[(S).salaire, (L).loyer, (A).Alimentation, (D).divers] : ");
			tmpC = lectureClavier.next().toUpperCase().charAt(0);
			
	    } while (tmpC != 'S' && tmpC != 'L' && tmpC != 'A' && tmpC != 'D');
		
		switch (tmpC){
			case 'S' : tmpS = "Salaire";
			break;
			case 'L' : tmpS = "Loyer";
			break;
			case 'A' : tmpS = "Alimentation";
			break;
			case 'D' : tmpS = "Divers";
			break;
		}
		return tmpS;
	}	
	
	private String controleModePaiement(){
		char tmpC;
		String tmpS = null;
		do { 
			System.out.print("[(C).CB, (Q).chèque, (V).virement] : ");	
			tmpC = lectureClavier.next().toUpperCase().charAt(0);
			
	    } while (tmpC != 'C' && tmpC != 'Q' && tmpC != 'V');
		
		switch (tmpC){
			case 'C' : tmpS = "CB";
			break;
			case 'Q' : tmpS = "chèque";
			break;
			case 'V' : tmpS = "virement";
			break;		
		}
		
		return tmpS;
	}
	
	
	// getter/setter
	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
