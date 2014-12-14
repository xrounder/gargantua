/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * @author 1414163
 *
 */
public class CrypterNull implements Crypter{


	@Override
	public String encrypt(String message) throws CrypterException {
	
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return cypherTexte;
	}



}
