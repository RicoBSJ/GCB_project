package fr.GCB.principale;

import java.util.Scanner;

public class LigneComptable {
		
	public double valeur = 0.0d;
	public String motif = null, modePaiement = null, date = null;
	
	Scanner lectureClavier = new Scanner(System.in);
	
	public void creerLigneComptable(){
		
		System.out.print("La somme à créditer (-) ou à debiter (+) : ");
		valeur = lectureClavier.nextInt();
		
		System.out.print("La date de l'opération (dd/mm/yyyy) : ");
		date = lectureClavier.next();
		
		do{
			System.out.print("Le motif [Salaire, Loyer, Alimentation, Divers] : ");
			motif = lectureClavier.next();
		
		}while(!motif.equalsIgnoreCase("Salaire") && !motif.equalsIgnoreCase("Loyer") && !motif.equalsIgnoreCase("Alimentation") && !motif.equalsIgnoreCase("Divers"));
		
		switch (motif){
			case "salaire" : motif = "Salaire";
			break;
			case "loyer" : motif = "Loyer";
			break;
			case "alimentation" : motif = "Alimentation";
			break;
			case "divers" : motif = "Divers";
			break;
		}
		
		do{
			System.out.print("Le mode de paiement [CB, Chèque, Virement] : ");
			modePaiement = lectureClavier.next().toLowerCase().replace('è', 'e');
		
		}while(!modePaiement.equalsIgnoreCase("cb") && !modePaiement.equalsIgnoreCase("cheque") && !modePaiement.equalsIgnoreCase("virement"));
		
		switch (modePaiement){
		case "cb" : modePaiement = "CB";
		break;
		case "cheque" : modePaiement = "Chèque";
		break;
		case "virement" : modePaiement = "Virement";
		break;
		}
		
		
	}
	
	public void afficherLigne(){
		
		System.out.println("\nEn date du : " + date);
		if(valeur > 0) System.out.println("- Montant créditer : " + valeur + "€");
		else System.out.println("- Montant débiter : " +valeur+ "€");
		System.out.println("- Motif : " + motif);
		System.out.println("- Moyen de paiement : " + modePaiement);	
	}
	
	
}
