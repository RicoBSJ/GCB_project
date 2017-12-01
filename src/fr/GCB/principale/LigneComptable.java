package fr.GCB.principale;

import java.util.Scanner;

public class LigneComptable {
		
	int sCredit, sDebit, valeur;
	String theme, moyenPaiement, numCompte, date;
	
	Scanner lectureClavier = new Scanner(System.in);
	
	public void creerLigne(){
		System.out.println("Remplir les information ci-dessous.\n");
		System.out.print("Le numéro du compte concerné : ");
		numCompte = lectureClavier.next();
		
		System.out.print("La somme à créditer (valeur positive) ou à debiter (valeur négative) : ");
		valeur = lectureClavier.nextInt();
		if(valeur > 0) sCredit += valeur;
		else sDebit += valeur;
		
		System.out.print("La date de l'opération (dd/mm/yyyy) : ");
		date = lectureClavier.next();
		
		do{
			System.out.print("Le motif de l'achat ou la ventes [thème possibles : Salaire, Loyer, Alimentation, Divers] : ");
			theme = lectureClavier.next();
		
		}while(theme.equalsIgnoreCase("Salaire") && theme.equalsIgnoreCase("Loyer") && theme.equalsIgnoreCase("Alimentation") && theme.equalsIgnoreCase("Divers"));
		
		do{
			System.out.println("Le mode de paiement [thème possibles : CB, chèque, virement] : ");
			moyenPaiement = lectureClavier.next().replace('é', 'e');
		
		}while(moyenPaiement.equalsIgnoreCase("CB") && moyenPaiement.equalsIgnoreCase("cheque") && moyenPaiement.equalsIgnoreCase("virement"));
	}
	
	public void afficherLigne(){
		System.out.print("\nSaissisez la date de l'opération (dd/mm/yyyy) : ");

		String date = lectureClavier.next();
					
		if(date.equalsIgnoreCase(this.date)){
			System.out.println("\nEn date du : " + date);
			System.out.println("Objet : " + theme);
			System.out.println("moyen de paiement : " + moyenPaiement);
			if(valeur > 0) System.out.println("Montant : " + sCredit);
			else System.out.println("Montant : " + sDebit);
	
		}else 
			System.out.println("\nAucune opératoin à cette date");
		
		
	}
	
	
}
