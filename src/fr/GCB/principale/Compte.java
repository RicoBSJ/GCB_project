package fr.GCB.principale;

import java.util.Scanner;

public class Compte {
	String typeCompte, numeroCompte;
	double valeur;
	float taux;
	
	Scanner lectureClavier = new Scanner(System.in);
	
	public void creerCompte(){
		do { 
			System.out.print("\nType du compte [Types possibles :" ); 
			System.out.print("courant, joint, épargne] :");		
			typeCompte = lectureClavier.nextLine().toLowerCase();
			typeCompte = typeCompte.replace('é', 'e');
		 } while (typeCompte.equalsIgnoreCase("courant") && typeCompte.equalsIgnoreCase("joint") && typeCompte.equalsIgnoreCase("epargne"));
		
			System.out.print("\nNuméro du compte : ");
			numeroCompte = lectureClavier.next();
			System.out.print("Première valeur créditée : ");
			valeur = lectureClavier.nextDouble();						
		 if ( typeCompte.equalsIgnoreCase("epargne")){
			System.out.print("Taux de placement : ");
			taux = lectureClavier.nextFloat();	
		 }
	}
	
	public void afficherCmpte(){
		System.out.println("\n***** 2.AFFIHCER UN COMPTE *****\n");
		System.out.print("\nSaissisez le numéro du compte : ");

		String compte = lectureClavier.next();
					
		if(compte.equalsIgnoreCase(numeroCompte))
			System.out.println("\nLe compte numero : " + numeroCompte
					+ "\n- est un compte : " + typeCompte
					+ "\n- à pour actif " + valeur + " €"
					+ "\n- à un taux de : " + taux +" %");		
			
		else 
			System.out.println("\nCe compte n'existe pas !");
		
	}
	

}
