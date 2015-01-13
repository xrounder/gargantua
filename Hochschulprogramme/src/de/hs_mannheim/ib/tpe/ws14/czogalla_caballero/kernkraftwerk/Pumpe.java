/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/** 
 *
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Pumpe implements Runnable{

	private double pumpleistung;
	
	public Pumpe(double pumpleistung){
		this.pumpleistung = pumpleistung;
	}
	
	@Override
	public synchronized void run() {
		
		while(true){
			
			if (Thread.currentThread().isInterrupted()){
				break;
			}
			try{
				Thread.sleep(1000);
				Leitware.ausgeben("a");
			} catch (InterruptedException e){
				break;
			}
		}
	
	}

}
