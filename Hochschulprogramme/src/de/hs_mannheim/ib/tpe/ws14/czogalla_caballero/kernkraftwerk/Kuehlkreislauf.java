/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import java.util.ArrayList;

/** 
 *stellt den Kühlkreislauf dar
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Kuehlkreislauf{

	private ArrayList<Wasserelement> wasserkreislauf;

	private int reaktorPos = 0;
	private int flussPos = 6;
	
	
	/**
	 * gibt wasserkreislauf zurück
	 * @return the wasserkreislauf
	 */
	public ArrayList<Wasserelement> getWasserkreislauf() {
		return wasserkreislauf;
	}

	/**
	 * setzt wasserkreislauf
	 * @param wasserkreislauf the wasserkreislauf to set
	 */
	public void setWasserkreislauf(ArrayList<Wasserelement> wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}

	/**
	 * gibt reaktorPosition zurück
	 * @return the reaktorPos
	 */
	public int getReaktorPos() {
		return reaktorPos;
	}

	/**
	 * setzt reaktorPosition
	 * @param reaktorPos the reaktorPos to set
	 */
	public void setReaktorPos(int reaktorPos) {
		this.reaktorPos = reaktorPos;
	}

	/**
	 * gibt flussPosition zurück
	 * @return the flussPos
	 */
	public int getFlussPos() {
		return flussPos;
	}

	/**
	 * setzt flussPosition
	 * @param flussPos the flussPos to set
	 */
	public void setFlussPos(int flussPos) {
		this.flussPos = flussPos;
	}

	/**
	 * Konstruktor
	 */
	public Kuehlkreislauf() {
		
		wasserkreislauf = new ArrayList<>(12);
		
		for (int i = 0; i < 12; i++) {
			
			wasserkreislauf.add(new Wasserelement());
		}
	}
	
	/**
	 * Hier wird das Wasser weiter gepumpt
	 */
	public void pumpen() {
	
		reaktorPos++;
		flussPos++;
		//reaktorPos=reaktorPos%12;
		//flussPos = flussPos%12;
		
		if(reaktorPos >= 12){
			reaktorPos = 0;
		}
		if(flussPos >= 12){
			flussPos = 0;
		}
	}
	
	
}
