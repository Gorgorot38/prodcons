package jus.poc.prodcons.v1;

import jus.poc.prodcons.Acteur;
import jus.poc.prodcons.Aleatoire;
import jus.poc.prodcons.ControlException;
import jus.poc.prodcons.Message;
import jus.poc.prodcons.Observateur;
import jus.poc.prodcons.Tampon;
import jus.poc.prodcons._Consommateur;

public class Consommateur extends Acteur implements _Consommateur {

	private int nbMsgConsomme;
	private Tampon tampon;
	private Aleatoire alea;
	private int affichage;


	public Consommateur(Observateur observateur, int moyenneTempsDeTraitement, int deviationTempsDeTraitement, Tampon tampon, Aleatoire alea, int affichage) throws ControlException {
		super(Acteur.typeConsommateur, observateur, moyenneTempsDeTraitement, deviationTempsDeTraitement);
		this.alea = alea;
		this.tampon = tampon;
		nbMsgConsomme = 0;
		this.affichage = affichage;
	}
	/**
	 * retourne le nombre de messages consommés
	 */
	public int nombreDeMessages() {
		return nbMsgConsomme;
	}


	public void run()
	{
		while(true)
		{
			try {
				Message msg = tampon.get(this);// recupere le message depuis le tampon
				if(affichage == 1){
					System.out.println("\t\tLecture IDCons "+identification() + " : "+msg);
				}
				//code pour quitter la boucle
				if(msg.toString().contains("pilule :true"))
				{
					break;
				}
				nbMsgConsomme++;
				int wait = 10*alea.next();
				sleep(wait);
			} catch ( Exception e) {
				e.printStackTrace();
			}//
		}
		if(affichage == 1){
			System.out.println("Stop : consommateur : " + identification() + " ayant consomme " + nbMsgConsomme + " messages");
		}
	}



}
