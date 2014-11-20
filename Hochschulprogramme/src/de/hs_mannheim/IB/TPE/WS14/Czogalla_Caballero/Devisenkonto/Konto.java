package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto;

/**
 * Objekttyp Konto; beinhaltet eine Waehrung, einen Inhaber, einen Kontostand
 * und eine Buchsnummer
 * 
 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto.Konto
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
public class Konto {
	private Waehrung waehrung;
	private String inhaber;
	private Betrag[] kontostand = new Betrag[1000];
	private int buchungsnummer = 0;

	/**
	 * übergibt waehrung und inhaber
	 * 
	 * @param waehrung
	 * @param inhaber
	 */
	public Konto(Waehrung waehrung, String inhaber) {
		this.waehrung = waehrung;
		this.inhaber = inhaber;
	}

	/**
	 * gibt waehrung zurück
	 * 
	 * @return
	 */
	public Waehrung getWaehrung() {
		return waehrung;
	}

	/**
	 * gibt Inhaber als String zurück
	 * 
	 * @return
	 */
	public String getInhaber() {
		return inhaber;
	}

	/**
	 * gibt kontostand als Array zurück
	 * 
	 * @return
	 */
	public Betrag[] getKontostand() {

		return kontostand;
	}

	/**
	 * fügt Betrag der Liste kontostand hinzu und achtet dabei auf eine korrekte
	 * Umrechnung der Währung
	 * 
	 * @param betrag
	 */
	public void buche(Betrag betrag) {

		if (buchungsnummer < 1000) {

			long umrechnung = betrag.getWaehrung().umrechnen(
					betrag.getBetrag(), betrag.getWaehrung());

			kontostand[buchungsnummer] = new Betrag(getWaehrung(),
					(double) umrechnung / 100);

			buchungsnummer++;

		}

	}

	/**
	 * berechnet den Saldo anhand aller Einträge von der Liste kontostand und
	 * gibt ihn als ein Betragsobjekt zurück
	 * 
	 * @return Betrag
	 */
	public Betrag saldo() {

		long saldo = 0;

		for (int index = 0; getKontostand()[index] != null
				&& index < getKontostand().length; index++) {

			saldo += getKontostand()[index].getBetrag();
		}

		return new Betrag(getWaehrung(), (double) saldo / 100d);
	}

	/**
	 * berechnet die Gebühren anhand des eingebenen Promillesatzes und dem Saldo
	 * 
	 * @param promille
	 */
	public void gebuehren(double promille) {

		buche(saldo().promille(promille));

	}

	/**
	 * Kontoauszug als String mit allen Buchungen, Gebühren und dem Saldo
	 * 
	 * @return ausgabe
	 */
	public String toString() {

		String ausgabe = "INTERNATIONAL LIES AND DECEPTION BANK COROPORATION \n\n";

		ausgabe += "Kontoauszug von: " + getInhaber() + "\n----------\n";

		for (int index = 0; getKontostand()[index] != null
				&& index < getKontostand().length; index++) {

			ausgabe += getKontostand()[index].toString() + "\n";
		}

		ausgabe += "----------\n" + "Saldo: " + saldo().toString();

		return ausgabe;
	}

}
