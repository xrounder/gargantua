/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * Umkehrverschlüsselung, die den Text rückwärts zurückgibt
 *
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 *
 */
public class CrypterReverse  extends CrypterBasis {

	/**
	 * dreht den Spieß um
	 * 
	 * @param message
	 * @return reversed gedrehter Spieß
	 * @returnType String
	 */
	private String reverse(String message){
		message = removeChars(message);
		String reversed = "";
		
		for(int pos = message.length()-1; pos >= 0; pos--){
			
			reversed += message.charAt(pos);
			
		}
		
		return reversed;
		
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		return reverse(message);
	}



	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return reverse(cypherText);
	}

	@Override
	protected boolean checkKey(String key) {
		
		return true;
	}

	

}
