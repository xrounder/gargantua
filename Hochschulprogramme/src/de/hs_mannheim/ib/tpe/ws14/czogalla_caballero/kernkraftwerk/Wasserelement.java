/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.locks.Lock;

/** 
 *Ein Wasserelement im Wasserkreislauf
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Wasserelement {

	private double temperatur;
	
	public Wasserelement() {
	
		this.temperatur = 10;
	}
	
	/**
	* Gibt temperatur zurück
	*
	* @return die Temperatur des Wasserelements
	*/
	public double getTemperatur() {
		
		synchronized (Lock.tempLock) {
	
			return temperatur;
		}
	}
	
	/**
	* setzt temperatur
	*
	* @param temperatur
	* 
	*/
	public void setTemperatur(double temperatur) {
		
		synchronized (Lock.tempLock) {
		
			this.temperatur = temperatur;
		}
	}
}
