/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import java.util.LinkedList;
import java.util.TimerTask;

/** 
 *
 *
 *@author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 *@date 12.01.2015
 */
public class Kuehlkreislauf extends TimerTask{

	private double[] wasserkreislauf = new double[12];
	private int reaktorTemp;
	private int kuehlwasserTemp;
	
	public Kuehlkreislauf(int reaktorTemp, int kuehlwasserTemp){
		
		this.reaktorTemp = reaktorTemp;
		this.kuehlwasserTemp = kuehlwasserTemp;
		
	}

	private int abwaerme(){
		
		return (kuehlwasserTemp + reaktorTemp)/2;
	}
	
	
	
	

	@Override
	public void run() {
	
		for(int element = 0; element < wasserkreislauf.length; element++){
			
			if(element < 6){
				
				wasserkreislauf[element] = abwaerme(); 
			
			}else{
				
				wasserkreislauf[element] = kuehlwasserTemp;
				
			}
			
			
			
		}
		
	}
	
	public void pumpen() {
		synchronized (Locks.positionsLock) {
			posReaktor++;
			posFlusswasser++;
			posReaktor = posReaktor % 12;
			posFlusswasser = posFlusswasser % 12;
		}
	}
	
	
}
