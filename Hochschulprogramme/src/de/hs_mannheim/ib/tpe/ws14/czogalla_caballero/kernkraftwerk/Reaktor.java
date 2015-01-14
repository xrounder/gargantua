/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/** 
 *REaktor eines Kernkraftwerks
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Reaktor implements Runnable{

	private final int ERWAERMUNGSKOEFFIZIENT = 42;
	private final int KRITISCHE_TEMP = 2878;
	private double abwaerme = 0;
	private Kuehlkreislauf kreislauf;
	private double eTemp;
	
	/**
	 * @return the abwaerme
	 */
	public double getAbwaerme() {
		return abwaerme;
	}


	/**
	 * @param abwaerme the abwaerme to set
	 */
	public void setAbwaerme(double abwaerme) {
		this.abwaerme = abwaerme;
	}


	/**
	 * @return the kreislauf
	 */
	public Kuehlkreislauf getKreislauf() {
		return kreislauf;
	}


	/**
	 * @param kreislauf the kreislauf to set
	 */
	public void setKreislauf(Kuehlkreislauf kreislauf) {
		this.kreislauf = kreislauf;
	}


	/**
	 * @return the eTemp
	 */
	public double geteTemp() {
		return eTemp;
	}


	/**
	 * @param eTemp the eTemp to set
	 */
	public void seteTemp(double eTemp) {
		this.eTemp = eTemp;
	}


	public Reaktor (Kuehlkreislauf kreislauf){
		this.kreislauf=kreislauf;
		
	}
	
	
	@Override
	public synchronized void run() {
		
		int zaehler = 0;
		
		while(abwaerme<KRITISCHE_TEMP && zaehler < 20){
			
				
			if (Thread.currentThread().isInterrupted()){
				break;
			}
			try{
				Thread.sleep(1000);
				abwaerme = kreislauf.getWasserkreislauf()[kreislauf.getReaktorPos()] + ERWAERMUNGSKOEFFIZIENT;
				//kreislauf.getWasserkreislauf()[kreislauf.getReaktorPos()] = abwaerme; 
			} catch (InterruptedException e){
				break;
			}
		}
		
		if(zaehler >= 20){
			System.out.println("Reaktor heruntergefahren.");
		}else{
			System.out.println("Kernschmelze");

		}
	}

}
