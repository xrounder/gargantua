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
public class Reaktor implements Runnable{

	private final int ERWAERMUNGSKOEFFIZIENT = 42;
	private final int KRITISCHE_TEMP = 2878;
	private double abwaerme = 0;
	
	
	
	@Override
	public void run() {
		
		while(abwaerme<KRITISCHE_TEMP){
			
				
			if (Thread.currentThread().isInterrupted()){
				break;
			}
			try{
				Thread.sleep(1000);
				abwaerme += ERWAERMUNGSKOEFFIZIENT;
				Leitware.ausgeben("" + abwaerme);
			} catch (InterruptedException e){
				break;
			}
		}
		System.out.println("Kernschmelze");
	}

}
