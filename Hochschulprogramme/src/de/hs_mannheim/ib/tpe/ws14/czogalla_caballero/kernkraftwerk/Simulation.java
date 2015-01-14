/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/** 
 * Simuliert ein tolles Kraftwerk
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
		
		Kuehlkreislauf k = new Kuehlkreislauf(10,10);
		Pumpe p = new Pumpe(2, k);
		Reaktor r = new Reaktor(k);
		
		Waermetauscher w1 = new Waermetauscher();
		Waermetauscher w2 = new Waermetauscher();
		
		Kraftwerk nichtFukushima = new Kraftwerk(w1, w2, k, p, r);
		
		Thread t = new Thread(nichtFukushima);
		t.start();

	}

}
