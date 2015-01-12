/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import java.util.LinkedList;

/** 
 *
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Kuehlkreislauf {

	private Wasserelement[] wasserkreislauf = new Wasserelement[12];
	Pumpe pumpe;
	
	
	public Kuehlkreislauf(Wasserelement[] wasserkreislauf, Pumpe pumpe){
		
		if (wasserkreislauf.length == 12){
			this.wasserkreislauf = wasserkreislauf;
			this.pumpe = pumpe;
		}		
		
	}
	
}
