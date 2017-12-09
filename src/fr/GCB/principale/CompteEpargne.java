package fr.GCB.principale;

public class CompteEpargne extends Compte {
	private double taux;
	
	public CompteEpargne(){
		super("Epargne");
		taux = controleTaux();
	}
	
	public void afficherCompte(){
		super.afficherCmpte();
		System.out.println("Le taux d'épargne du compte est " +taux+ "%.");		
	}
	
	//Methode controle de saisi
	public double controleTaux(){
		double tmpd;
		do { 
			System.out.print("Taux de placement : ");
			tmpd = lectureClavier.nextDouble();
			if(tmpd < 0) System.out.print("Entrez un taux positif :");
			
	    } while (tmpd < 0); 
		
		return tmpd;			
		
	}
	
}
