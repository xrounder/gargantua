/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/** 
 *tauscht Wärme
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Waermetauscher {

	/**
	 * 	
	 * @param eTemp Eingangstemperatur
	 * @param kTemp Kühltemperatur
	 * @return Ausgangstemperatur
	 */
	public double tauschen (double eTemp, double kTemp){
		
		return 0.5*(eTemp + kTemp);
	}
	
	
}
