package jus.poc.prodcons.v6;

public class Semaphore {

	private int cpt;
	
	public Semaphore(int taille) {
		cpt = taille;
	}
	
	public synchronized void p() throws InterruptedException
	{
		if(--cpt < 0){
			wait();
		}
	}
	
	public synchronized void v()
	{
		if(++cpt <= 0){
			notify();
		}
	}
	
	

}