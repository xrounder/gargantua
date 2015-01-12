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
public class Simulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reaktor reaktor = new Reaktor();
		Thread reaktor1 = new Thread(reaktor, "Reaktor 1");

		reaktor1.start();
	}

}
