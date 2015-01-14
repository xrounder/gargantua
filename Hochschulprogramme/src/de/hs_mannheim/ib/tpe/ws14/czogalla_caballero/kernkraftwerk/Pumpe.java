/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/**
 * Pumpt das Wasser mit angegebener Leistung in einem Kühlkreislauf
 *
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 * @date 12.01.2015
 */
public class Pumpe implements Runnable {

	private double pumpleistung;
	private Kuehlkreislauf kreislauf;
	private volatile boolean kernschmelze = false;

	/**
	 * @return the kernschmelze
	 */
	public boolean isKernschmelze() {
		return kernschmelze;
	}

	/**
	 * @param kernschmelze the kernschmelze to set
	 */
	public void setKernschmelze(boolean kernschmelze) {
		this.kernschmelze = kernschmelze;
	}

	/**
	 *
	 * @param pumpleistung
	 * @param kuehlkreislauf
	 */
	public Pumpe(double pumpleistung, Kuehlkreislauf kreislauf) {
		this.pumpleistung = pumpleistung;
		this.kreislauf = kreislauf;
	}

	/**
	 * Gibt die Pumpleistung der Pumpe zurueck
	 *
	 * @return die Pumpleistung
	 */
	public double getPumpleistung() {
		return pumpleistung;
	}

	/**
	 * Setzt pumpleistung
	 *
	 * @param pumpleistung
	 */
	public void setPumpleistung(double pumpleistung) {
		this.pumpleistung = pumpleistung;
	}

	/**
	 * Gibt den kreislauf zurück
	 *
	 * @return kreislauf
	 */
	public Kuehlkreislauf getKuehlkreislauf() {
		return kreislauf;
	}

	/**
	 * ReaktorThread läuft hier ab
	 */
	public synchronized void run() {
		
		while (true) {
		
			if (!kernschmelze) {
				kreislauf.pumpen();
				
				try {
					wait(Math.round(1000 / pumpleistung));
					
				} catch (InterruptedException e) {
					System.out.println("Pumpe wurde heruntergefahren.");
					break;
				}
				
			}else{
				break;
			}
		}
	}

}
