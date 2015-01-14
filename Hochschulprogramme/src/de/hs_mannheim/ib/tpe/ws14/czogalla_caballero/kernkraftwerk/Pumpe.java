/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/** 
 *Pumpt das Wasser mit angegebener Leistung in einem Kühlkreislauf
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Pumpe implements Runnable{

	private double pumpleistung;
	private Kuehlkreislauf kuehlkreislauf;
	
	public Pumpe(double pumpleistung, Kuehlkreislauf kuehlkreislauf){
		this.pumpleistung = pumpleistung;
		this.kuehlkreislauf = kuehlkreislauf;
	}
	
	@Override
	public synchronized void run() {
		
		while(true){
			
			if (Thread.currentThread().isInterrupted()){
				break;
			}
			try{
				kuehlkreislauf.pumpen();
				Thread.sleep(Math.round(1000 / pumpleistung));
				
			} catch (InterruptedException e){
				break;
			}
		}
	
	}

}
