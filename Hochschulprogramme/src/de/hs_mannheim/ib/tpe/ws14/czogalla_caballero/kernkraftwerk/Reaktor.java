/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.kernkraftwerk;

/**
 * Reaktor eines Kernkraftwerks
 *
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 *
 * @date 12.01.2015
 */
public class Reaktor implements Runnable {

	private final int abwaerme;
	final static int KRITISCHE_TEMP = 2878;
	private volatile boolean kernschmelze = false;
	private Wasserelement wasser;
	
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
	 * Konstruktor
	 *
	 * @param wasser
	 * @param abwaerme
	 */
	public Reaktor(Wasserelement wasser, int abwaerme) {
		this.wasser = wasser;
		this.abwaerme = abwaerme;
	}

	/**
	 * Gibt das Wasserelement des Reaktors zurueck
	 *
	 * @return der Wasserelement
	 */
	public Wasserelement getWasser() {
		return wasser;
	}

	/**
	 *setzt wasser
	 *
	 * @param wasser
	 */
	public void setWasser(Wasserelement wasser) {
		this.wasser = wasser;
	}
	
	/**
	 *Thread läuft hier ab
	 */
	public synchronized void run() {
		
		while (!kernschmelze) {
		
			wasser.setTemperatur(wasser.getTemperatur() + 1);
			
			if (wasser.getTemperatur() >= KRITISCHE_TEMP) {
				
				System.out.println("KRAFTWERK IST EXPLODIERT!");
				this.kernschmelze = true;
			}
			try {
				wait(Math.round(1000.0 / abwaerme));
				
			} catch (InterruptedException e) {
				System.out.println("Reaktor wurde heruntergefahren");
				break;
			}
		}
	}
}
