package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto;

/**
 * Objekttyp Betrag, welche eine Waehrung und einen Betrag enthält.
 * 
 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto.Waehrung
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
final class Betrag {

	private final Waehrung waehrung;
	private final long betrag;

	/**
	 * Konstruktor mit double
	 * 
	 * @param waehrung
	 * @param betrag
	 */
	public Betrag(Waehrung waehrung, double betrag) {

		this.waehrung = waehrung;
		this.betrag = (long) (betrag * 100);

	}

	/**
	 * Konstruktor mit long
	 * 
	 * @param waehrung
	 * @param betrag
	 */
	public Betrag(Waehrung waehrung, long betrag) {

		this.waehrung = waehrung;
		this.betrag = betrag * 100;
	}

	/**
	 * übergibt betrag
	 * 
	 * @return betrag
	 */
	public long getBetrag() {

		return betrag;
	}

	/**
	 * übergibt waehrung
	 * 
	 * @return waehrung
	 */
	public Waehrung getWaehrung() {

		return waehrung;
	}

	/**
	 * addiert den betrag mit einem anderen Betrag
	 * 
	 * @param betrag
	 * @return summe
	 */
	public Betrag addiere(Betrag betrag) {

		Betrag summe = new Betrag(getWaehrung(),
				(double) (getBetrag() + betrag.getBetrag()) / 100);
		return summe;

	}

	/**
	 * subtrahiert den anderen Betrag vom betrag
	 * 
	 * @param betrag
	 * @return differenz
	 */
	public Betrag subtrahiere(Betrag betrag) {

		Betrag differenz = new Betrag(getWaehrung(),
				(double) (getBetrag() - betrag.getBetrag()) / 100);
		return differenz;
	}

	/**
	 * multipliziert den betrag mit einem double-Wert
	 * 
	 * @param wert
	 * @return produkt
	 */
	public Betrag multipliziere(double wert) {

		Betrag produkt = new Betrag(getWaehrung(),
				(double) (getBetrag() / 100d * wert));
		return produkt;
	}

	/**
	 * multipliziert den betrag mit einem int-Wert
	 * 
	 * @param wert
	 * @return produkt
	 */
	public Betrag multipliziere(int wert) {

		Betrag produkt = new Betrag(getWaehrung(),
				(double) (getBetrag() / 100d * wert));
		return produkt;
	}

	/**
	 * errechnet einen Prozentwert von betrag
	 * 
	 * @param prozent
	 * @return ergebnis
	 */
	public Betrag prozent(double prozent) {

		Betrag ergebnis = multipliziere(prozent / 100);
		return ergebnis;
	}

	/**
	 * errechnet den Promillewert von betrag
	 * 
	 * @param promille
	 * @return ergebnis
	 */
	public Betrag promille(double promille) {

		Betrag ergebnis = multipliziere(promille / 1000);
		return ergebnis;
	}

	/**
	 * ermittelt den Wert vor dem Komma
	 * 
	 * @return vorkommastelle
	 */
	public long getVorkomma() {

		long vorkommastelle = Math.abs(getBetrag() / 100);

		return vorkommastelle;
	}

	/**
	 * ermittelt die ersten zwei Nachkommastellen
	 * 
	 * @return nachkommastelle
	 */
	public long getNachkomma() {

		long nachkommastelle = Math.abs(getBetrag() % 100);

		return nachkommastelle;
	}

	/**
	 * wandelt den Betrag in eine Zeichenkette um
	 * 
	 * @return zeichenkette
	 */
	public String toString() {

		String zeichenkette = String.format("%.2f %s", getAsDouble(),
				getWaehrung().getKuerzel());
		return zeichenkette;

	}

	/**
	 * wandelt den betrag in ein double-Wert um
	 * 
	 * @return kommazahl
	 */
	public double getAsDouble() {

		double kommazahl = (double) (getBetrag() / 100d);

		return kommazahl;
	}

	/**
	 * prüft, ob zwei Objekte gleich sind
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Betrag other = (Betrag) obj;
		if (betrag != other.betrag)
			return false;
		if (waehrung == null) {
			if (other.waehrung != null)
				return false;
		} else if (!waehrung.equals(other.waehrung))
			return false;
		return true;
	}

	/**
	 * prüft ob der Betrag negativ oder positiv ist
	 * 
	 * @return 1 bei positiven Vorzeichen
	 * @return -1 bei negativen Vorzeichen
	 */
	public int getVorzeichen() {

		if (getBetrag() >= 0) {

			return 1;

		} else {

			return -1;
		}

	}
}
