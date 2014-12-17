/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

/**
 * XOR Verschlüsselung,
 * 
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 * 
 */
public class CrypterXOR extends CrypterBasis {

	private final String ALPHABET = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_";

	public CrypterXOR(String key) throws IllegalKeyException {
		if (checkKey(this.removeChars(key)))
			this.key = key;
		else
			throw new IllegalKeyException(
					"Ungültiger Schlüssel! Gebe nur Buchstaben ein.");

	}

	// wird überschrieben, da bei XOR die zusätzlichen Zeichen [ @ \ ] ^ _
	// erlaubt sind und nicht gelöscht werden sollen
	@Override
	protected String removeChars(String text) {

		text = text.trim();
		text = text.toUpperCase();
		String removed = "";

		for (int pos = 0; pos < text.length(); pos++) {

			for (int posAlph = 0; posAlph < this.ALPHABET.length(); posAlph++) {

				if (text.charAt(pos) == this.ALPHABET.charAt(posAlph)) {

					removed += text.charAt(pos);

				}

			}

		}

		return removed;
	}

	/**
	 * da ver- und entschlüsseln gleich sind, ist hier eine extra Methode für
	 * die explizitesOder-Abfrage
	 * 
	 * @param message
	 * @return crypted ver- oder entsdchlüsselter Text
	 * @returnType String
	 */
	private String xor(String message) {

		// entfernt alle ungültigen Zeichen
		message = removeChars(message);

		String crypted = "";

		// falls Schlüssel kürzer als Nachricht, dann wiederhole Schlüssel
		if (message.length() > key.length()) {

			int missing = message.length() - key.length();

			for (int pos = 0; pos < missing; pos++) {

				key += key.charAt(pos);
			}

		}

		// verschlüsselt den ganzen Text
		for (int pos = 0; pos < message.length(); pos++) {

			int keyValue = 0;
			int textValue = 0;

			for (int posKey = 0; posKey < ALPHABET.length(); posKey++) {

				// finde heraus, welche Stelle der Buchstabe von message im
				// Alphabet hat
				if (message.charAt(pos) == ALPHABET.charAt(posKey)) {

					textValue = (posKey);
				}

				// finde heraus, welche Stelle der Buchstabe von Key im Alphabet
				// hat
				if (key.charAt(pos) == ALPHABET.charAt(posKey)) {

					keyValue = (posKey);
				}

			}

			// füge den verschlüsselten Buchstaben hinzu
			crypted += ALPHABET.charAt(textValue ^ keyValue);
		}

		return crypted;
	}

	@Override
	public String encrypt(String message) throws CrypterException {

		return xor(message);

	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		return xor(cypherText);
	}

	@Override
	protected boolean checkKey(String key) {

		return true;
	}

}
