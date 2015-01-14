/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.locks.Lock;

/**
 * tauscht Wärme
 *
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 * @date 12.01.2015
 */
public class Waermetauscher {

	double ausgangsTemp;
	
	
	/**
	 * gibt ausgangstemperatur zurück
	 * @return the ausgangsTemp
	 */
	public double getAusgangsTemp() {
		return ausgangsTemp;
	}


	/**
	 * setzt ausgangstemperatur
	 * @param ausgangsTemp the ausgangsTemp to set
	 */
	public void setAusgangsTemp(double ausgangsTemp) {
		this.ausgangsTemp = ausgangsTemp;
	}


	/**
	 * tauscht die Wärme zwischen 2 Wasserelementen
	 * @param element1
	 * @param element2
	 */
	public void tauschen(Wasserelement element1, Wasserelement element2) {
		
		synchronized (Lock.tempLock) {
		
			double ausgangsTemp = 0.5*(element1.getTemperatur() + element2
					.getTemperatur());
			
			element1.setTemperatur(ausgangsTemp);
			element2.setTemperatur(ausgangsTemp);
			
			this.ausgangsTemp = ausgangsTemp;
		}
	}
	
}
