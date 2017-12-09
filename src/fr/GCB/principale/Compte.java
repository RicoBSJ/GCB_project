package fr.GCB.principale;

import java.util.Scanner;

public class Compte {
	private String typeCompte, numeroCompte;
	private double valeur;
	private int nbLigneCompta;
	LigneComptable ligne;
	
	Scanner lectureClavier = new Scanner(System.in);	

	public Compte(){
		System.out.print("\nType du compte " ); 
		typeCompte = controleType();
		
		System.out.print("\nNuméro du compte : ");
		numeroCompte = lectureClavier.next();
		
		System.out.print("Première valeur à créditer : ");
		valeur = controleValeur();

		 nbLigneCompta = 0;
	}
	
	//Construteur default pour compte épargne
	public Compte(String type){
		if(type.equals(typeCompte)){
			this.typeCompte = type;
			
			System.out.print("\nNuméro du compte : ");
			numeroCompte = lectureClavier.next();
			
			System.out.print("Première valeur à créditer : ");
			valeur = controleValeur();

			 nbLigneCompta = 0;
		}
	}
	
	public void creerLigne(){
		ligne = new LigneComptable();		
		nbLigneCompta++;
		valeur += ligne.getValeur();
	}
	
	public void afficherCmpte(){
			System.out.print("\nSaissisez le numéro du compte : ");
	
			String compte = lectureClavier.next();
						
			if(compte.equalsIgnoreCase(numeroCompte)){
				System.out.println("\nLe compte numero " + numeroCompte+ " :"
						+ "\n- est un compte : " + typeCompte
						+ "\n- à pour actif " + valeur + " €");
						
				//Vérifie l'existance d'une ligne comptable et l'affiche
				if(nbLigneCompta == 1) ligne.afficherLigne();
									
			}else {
				System.out.println("\nCe compte n'existe pas !");
			}
		
	}
	
	//Méthodes de controle de saisie
	private String controleType(){
		char tmpC;
		String tmpS = null;
		do { 
			System.out.print("[(C).courant, (J).joint] : ");		
			tmpC = lectureClavier.next().toUpperCase().charAt(0);
			
	    } while (tmpC != 'C' && tmpC != 'J');
		
		switch (tmpC){
			case 'C' : tmpS = "Courant";
			break;
			case 'J' : tmpS = "Joint";
			break;		
		}
		
		return tmpS;
	}
	
	private double controleValeur(){
		double tmpd;
		do { 
			tmpd = lectureClavier.nextDouble();
			if(tmpd < 0) System.out.print("Entrez une valeur positive :");
			
	    } while (tmpd < 0); 
		
		return tmpd;			
	}
	

	////guetteur/setteur
	
	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public int getNbLigneCompta() {
		return nbLigneCompta;
	}

	public void setNbLigneCompta(int nbLigneCompta) {
		this.nbLigneCompta = nbLigneCompta;
	}

	


}
