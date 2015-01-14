/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.simulationen;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.Kraftwerk;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.Kuehlkreislauf;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.Pumpe;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.Reaktor;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.Waermetauscher;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.Wasserelement;

/** 
 * Simuliert ein tolles Kraftwerk
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class TollSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Waermetauscher w1 = new Waermetauscher();
		Waermetauscher w2 = new Waermetauscher();
		Kuehlkreislauf k = new Kuehlkreislauf();
		Pumpe p = new Pumpe(5, k);
		Reaktor r = new Reaktor(new Wasserelement(), 60);
		
		Kraftwerk toll = new Kraftwerk(w1,w2,k,p,r);
		Thread t = new Thread(toll);
		t.start();
	}
	

}
