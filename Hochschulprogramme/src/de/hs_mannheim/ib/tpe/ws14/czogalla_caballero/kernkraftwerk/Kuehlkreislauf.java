/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import java.util.LinkedList;
import java.util.TimerTask;

/** 
 *stellt den Kühlkreislauf dar
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Kuehlkreislauf{

	private double[] wasserkreislauf = new double[12];

	private int reaktorPos = 0;
	private int flussPos = 6;
	
	
	/**
	 * @return the wasserkreislauf
	 */
	public double[] getWasserkreislauf() {
		return wasserkreislauf;
	}

	/**
	 * @param wasserkreislauf the wasserkreislauf to set
	 */
	public void setWasserkreislauf(double[] wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}

	/**
	 * @return the reaktorPos
	 */
	public int getReaktorPos() {
		return reaktorPos;
	}

	/**
	 * @param reaktorPos the reaktorPos to set
	 */
	public void setReaktorPos(int reaktorPos) {
		this.reaktorPos = reaktorPos;
	}

	/**
	 * @return the flussPos
	 */
	public int getFlussPos() {
		return flussPos;
	}

	/**
	 * @param flussPos the flussPos to set
	 */
	public void setFlussPos(int flussPos) {
		this.flussPos = flussPos;
	}

	
	public Kuehlkreislauf(int reaktorTemp, int flussTemp){
		
		this.wasserkreislauf[reaktorPos]  = reaktorTemp;
		this.wasserkreislauf[flussPos]  = flussTemp;
	}
	
	/**
	 * Hier wird das Wasser weiter gepumpt
	 */
	public void pumpen() {
	
		reaktorPos++;
		flussPos++;
		
		if(reaktorPos >= 12){
			reaktorPos = 0;
		}
		if(flussPos >= 12){
			flussPos = 0;
		}
	}
	
	
}
