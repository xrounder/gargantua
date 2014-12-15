/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * @author 1414163
 *
 */
public class CrypterNull extends CrypterBasis implements Crypter{


	@Override
	public String encrypt(String message) throws CrypterException {
		message = removeChars(message);
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		cypherText = removeChars(cypherText);
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return cypherTexte;
	}



}
