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
public class Kraftwerk {

	private Waermetauscher flusswasserK�hlung = new Waermetauscher(10);
	private Waermetauscher reaktorK�hlung = new Waermetauscher(10);

	Kuehlkreislauf kreislauf;
	
	
	public Kraftwerk(){
		
	}
	
}
