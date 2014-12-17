/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * Verschlüsselung, die nichts tut
 *
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 *
 */
public class CrypterNull extends CrypterBasis{


	public CrypterNull (String key){
		
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		message = removeChars(message);
		return message;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		cypherText = removeChars(cypherText);
		return cypherText;
	}

	@Override
	protected boolean checkKey(String key) {
		
		return true;
	}

	



}
