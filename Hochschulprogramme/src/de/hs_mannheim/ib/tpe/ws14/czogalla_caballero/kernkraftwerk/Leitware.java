/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/** 
 *Klasse für die Bildschirmausgabe
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Leitware {

	
	public static void ausgeben(double reaktorTemp, double flussTemp){
		System.out.println("Temperatur Reaktor: " + reaktorTemp + ", Temperatur Rückfluss in Rhein " + flussTemp);
	}
}
