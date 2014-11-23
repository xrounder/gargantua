package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto;

/**
 * Objekttyp Waehrung, welche aus einem Namen, einem Kürzel und einem Kurs zum
 * Dollar besteht.
 * 
 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto.Waehrungen;
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
final class Waehrung {

	private final String name;
	private final String kuerzel;
	private final long kurs;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param kuerzel
	 * @param kurs
	 */
	public Waehrung(String name, String kuerzel, long kurs) {
		this.name = name;
		this.kuerzel = kuerzel;
		this.kurs = kurs;
	}

	/**
	 * übergibt name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * übergibt kuerzel
	 * 
	 * @return kuerzel
	 */
	public String getKuerzel() {

		return kuerzel;
	}

	/**
	 * übergibt kurs
	 * 
	 * @return kurs
	 */
	public long getKurs() {
		return kurs;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Waehrung [name=" + name + ", kuerzel=" + kuerzel + ", kurs="
				+ kurs + "]";
	}

	/**
	 * ermittelt den hash-Code des Objekts
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kuerzel == null) ? 0 : kuerzel.hashCode());
		result = prime * result + (int) (kurs ^ (kurs >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * prüft ob, zwei Objekte gleich sind
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
		Waehrung other = (Waehrung) obj;
		if (kuerzel == null) {
			if (other.kuerzel != null)
				return false;
		} else if (!kuerzel.equals(other.kuerzel))
			return false;
		if (kurs != other.kurs)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * rechnet einen Betrag in die Zielwährung um
	 * 
	 * @param betrag
	 * @param zielwaehrung
	 * @return neuerBetrag
	 */
	public long umrechnen(long betrag, Waehrung zielwaehrung) {

		long neuerBetrag;

		neuerBetrag = betrag * kurs / zielwaehrung.getKurs();

		return neuerBetrag;
	}

}
