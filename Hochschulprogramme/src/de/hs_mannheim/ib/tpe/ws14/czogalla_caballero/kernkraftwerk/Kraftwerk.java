/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/**
 *Stellt ein Kraftwerk dar
 *
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 * @date 12.01.2015
 */
public class Kraftwerk implements Runnable{

	private Waermetauscher reaktorK�hlung;
	private Waermetauscher flusswasserK�hlung;
	private Kuehlkreislauf kreislauf;
	private Pumpe pumpe;
	private Reaktor reaktor;

	public Kraftwerk(Waermetauscher reaktorK�hlung, Waermetauscher flusswasserK�hlung,
			Kuehlkreislauf kreislauf, Pumpe pumpe, Reaktor reaktor) {
		
		this.reaktorK�hlung = reaktorK�hlung;
		this.flusswasserK�hlung = flusswasserK�hlung;
		this.kreislauf = kreislauf;
		this.pumpe = pumpe;
		this.reaktor = reaktor;
	}

	
	public synchronized void run(){
	
		Thread tReaktor = new Thread(reaktor);
		Thread tPumpe = new Thread(pumpe);
		tReaktor.start();
		tPumpe.start();
		
		while(true){
			
			kreislauf.getWasserkreislauf()[kreislauf.getReaktorPos()] =
					reaktorK�hlung.tauschen(reaktor.getAbwaerme(), kreislauf.getWasserkreislauf()[kreislauf.getReaktorPos()]);
			
			kreislauf.getWasserkreislauf()[kreislauf.getFlussPos()] =
					flusswasserK�hlung.tauschen(10, kreislauf.getWasserkreislauf()[kreislauf.getFlussPos()]);
			
			Leitware.ausgeben(reaktor.getAbwaerme(), kreislauf.getWasserkreislauf()[kreislauf.getFlussPos()]);
		
			if (Thread.currentThread().isInterrupted()){
				break;
			}
			try{
				tPumpe.join();
				
			} catch (InterruptedException e){
				break;
			}
		
		
		
		}
		
	}
}
