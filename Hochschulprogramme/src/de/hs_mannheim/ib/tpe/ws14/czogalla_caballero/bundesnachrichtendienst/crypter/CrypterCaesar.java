/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

/**
 * Caesar-Verschlüsselun; verschiebt den Text um den angegebenen Schlüssel nachr
 * echts im Aplhabet
 * 
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 * 
 */
public class CrypterCaesar extends CrypterBasis {

	public CrypterCaesar(String key) throws IllegalKeyException{

		if (checkKey(key))
			this.key=key;
		else
			throw new IllegalKeyException("Ungültiger Schlüssel! Gebe nur einen Buchstaben aus dem Alphabet ein.");

	}

	/**
	 * Findet die entsprechende Zahl zum eingegebenen Schlüssel
	 * 
	 * @return cryptedPos entsprechende Zahl zum Buchstaben
	 * @returnType int
	 */
	private int cryptedPosition(){

		int cryptedPos = 0;

		
		for (int pos = 0; pos < ALPHABET.length(); pos++) {

			if (key.charAt(0) == ALPHABET.charAt(pos)) {

				cryptedPos = pos + 1;
			}
		}
		
		return cryptedPos;
	}

	@Override
	protected boolean checkKey(String key) {

		key=key.toUpperCase();

		for (int pos = 0; pos < ALPHABET.length(); pos++) {
			if (ALPHABET.charAt(pos) == key.charAt(0))
				return true;
		}
		return false;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		String cryptedMessage = "";

		

			cypherText = removeChars(cypherText);
			char cryptedLetter;

			int cryptedPos = cryptedPosition();

			for (int posMsg = 0; posMsg < cypherText.length(); posMsg++) {

				for (int letterPos = 0; letterPos < ALPHABET.length(); letterPos++) {

					if (cypherText.charAt(posMsg) == ALPHABET.charAt(letterPos)) {

						// zielposition schießt übers alphabet hinaus
						if (letterPos - cryptedPos < 0) {

							cryptedLetter = ALPHABET.charAt(ALPHABET.length()
									+ letterPos - cryptedPos);

						} else {

							cryptedLetter = ALPHABET.charAt(letterPos
									- cryptedPos);

						}

						cryptedMessage += cryptedLetter;

					}

				}

			}
		
		return cryptedMessage;

	}

	@Override
	public String encrypt(String message) throws CrypterException {

		message = removeChars(message);
		String cryptedMessage = "";
		char cryptedLetter;

		int cryptedPos = cryptedPosition();

		for (int posMsg = 0; posMsg < message.length(); posMsg++) {

			for (int letterPos = 0; letterPos < ALPHABET.length(); letterPos++) {

				if (message.charAt(posMsg) == ALPHABET.charAt(letterPos)) {

					// zielposition schießt übers alphabet hinaus
					if (letterPos + cryptedPos > ALPHABET.length() - 1) {

						cryptedLetter = ALPHABET.charAt(letterPos + cryptedPos
								- ALPHABET.length());

					} else {

						cryptedLetter = ALPHABET.charAt(letterPos + cryptedPos);

					}

					cryptedMessage += cryptedLetter;

				}

			}

		}

		return cryptedMessage;
	}

}
