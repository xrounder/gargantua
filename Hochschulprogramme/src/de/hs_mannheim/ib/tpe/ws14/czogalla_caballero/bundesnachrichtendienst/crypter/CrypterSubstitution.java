package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

/**
 * Ersetzt den jeweiligen Buchstaben durch den Buchstaben des Schlüssels an
 * selbiger Position
 * 
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 * 
 */
public class CrypterSubstitution extends CrypterBasis {

	public CrypterSubstitution(String key) throws IllegalKeyException {

		if (checkKey(key))
			this.key = key;
		else
			throw new IllegalKeyException(
					"Ungültiger Schlüssel! Kein Buchstabe darf doppelt vorkommen. Der Schlüssel muss aus 26 Buchstaben bestehen.");

	}

	@Override
	public String encrypt(String message) throws CrypterException {

		message = removeChars(message);
		String crypted = "";

		for (int pos = 0; pos < message.length(); pos++) {

			for (int posKey = 0; posKey < key.length(); posKey++) {

				if (message.charAt(pos) == ALPHABET.charAt(posKey)) {

					crypted += key.charAt(posKey);

				}

			}
		}

		return crypted;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		cypherText = removeChars(cypherText);
		String crypted = "";

		for (int pos = 0; pos < cypherText.length(); pos++) {

			for (int posKey = 0; posKey < key.length(); posKey++) {

				if (cypherText.charAt(pos) == key.charAt(posKey)) {

					crypted += ALPHABET.charAt(posKey);
				}

			}
		}

		return crypted;
	}

	@Override
	protected boolean checkKey(String key) {

		key = removeChars(key);
		boolean isValid = true;
		
		if (key.length() != 26){
			
			isValid = false;
		
		}else{
		
			for (int pos = 0; pos < key.length(); pos++) {

				for (int index = 0; index < key.length(); index++) {

					if (key.charAt(index) == key.charAt(pos) && pos != index) {

						isValid = false;
					}

				}

			}
		}
		
		return isValid;
	}

}
