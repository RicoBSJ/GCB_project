package fr.GCB.principale;

import java.util.Scanner;

public class Compte {
	public String typeCompte, numeroCompte;
	public double valeur, taux;
	public int nbLigneCompta;
	LigneComptable ligne;
	
	Scanner lectureClavier = new Scanner(System.in);
	
	public void creerCompte(){
		do { 
			System.out.print("\nType du compte [Types possibles :" ); 
			System.out.print("Courant, Joint, Epargne] :");		
			typeCompte = lectureClavier.next().toLowerCase();
			typeCompte = typeCompte.replace('é', 'e');
		 } while (!typeCompte.equalsIgnoreCase("courant") && !typeCompte.equalsIgnoreCase("joint") && !typeCompte.equalsIgnoreCase("epargne"));
		
		switch (typeCompte){
			case "courant" : typeCompte = "Courant";
			break;
			case "joint" : typeCompte = "Joint";
			break;
			case "epargne" : typeCompte = "Epargne";
			break;
	}
			System.out.print("\nNuméro du compte : ");
			numeroCompte = lectureClavier.next();
			System.out.print("Première valeur à créditée : ");
			valeur = lectureClavier.nextDouble();						
		 if ( typeCompte.equalsIgnoreCase("epargne")){
			System.out.print("Taux de placement : ");
			taux = lectureClavier.nextDouble();	
		 };

	}
	
	public void creerLigne(){
		ligne = new LigneComptable();		
		ligne.creerLigneComptable();
		nbLigneCompta++;
		valeur += ligne.valeur;
	}
	
	public void afficherCmpte(){
		System.out.print("\nSaissisez le numéro du compte : ");

		String compte = lectureClavier.next();
					
		if(compte.equalsIgnoreCase(numeroCompte)){
			System.out.println("\nLe compte numero : " + numeroCompte
					+ "\n- est un compte : " + typeCompte
					+ "\n- à pour actif " + valeur + " €");
			//Affiche uniquement si le compte est de type épargne
			if(typeCompte.equals("epargne"))	System.out.println("\n- à un taux de : " + taux +" %");
			//Vérifie l'existance d'une ligne comptable et l'affiche
			if(nbLigneCompta == 1) ligne.afficherLigne();
								
		}else {
			System.out.println("\nCe compte n'existe pas !");
		}
		
	}
	


}
