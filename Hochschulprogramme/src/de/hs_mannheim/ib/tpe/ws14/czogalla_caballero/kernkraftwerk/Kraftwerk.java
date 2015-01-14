/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk.locks.Lock;

/**
 *Stellt ein Kraftwerk dar
 *
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 * @date 12.01.2015
 */
public class Kraftwerk implements Runnable{

	private Waermetauscher reaktorKühlung;
	private Waermetauscher flusswasserKühlung;
	private Kuehlkreislauf kreislauf;
	private Pumpe pumpe;
	private Reaktor reaktor;

	/**
	 * Konstruktor
	 * @param reaktorKühlung
	 * @param flusswasserKühlung
	 * @param kreislauf
	 * @param pumpe
	 * @param reaktor
	 */
	public Kraftwerk(Waermetauscher reaktorKühlung, Waermetauscher flusswasserKühlung,
			Kuehlkreislauf kreislauf, Pumpe pumpe, Reaktor reaktor) {
		
		this.reaktorKühlung = reaktorKühlung;
		this.flusswasserKühlung = flusswasserKühlung;
		this.kreislauf = kreislauf;
		this.pumpe = pumpe;
		this.reaktor = reaktor;
	}

	/**
	 * hier läuft Thread ab
	 */
	public synchronized void run(){
	
		Thread tReaktor = new Thread(reaktor);
		Thread tPumpe = new Thread(pumpe);
		tReaktor.start();
		tPumpe.start();
		int zaehler=1;
		
		while (zaehler <= 20 && !reaktor.isKernschmelze()) {
			
			synchronized (Lock.posLock) {
				
				reaktorKühlung.tauschen(kreislauf.getWasserkreislauf().get(kreislauf.getReaktorPos()), reaktor.getWasser());
				flusswasserKühlung.tauschen(kreislauf.getWasserkreislauf().get(kreislauf.getFlussPos()), new Wasserelement());
			
			}
			
			Leitware.ausgeben(reaktorKühlung.getAusgangsTemp(), flusswasserKühlung.getAusgangsTemp());
			
			zaehler++;
			
			try {
				wait(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
		if (reaktor.isKernschmelze()) {
			pumpe.setKernschmelze(true);
			
		} else {
			tReaktor.interrupt();
			tPumpe.interrupt();
		}
		
		
	}
}
