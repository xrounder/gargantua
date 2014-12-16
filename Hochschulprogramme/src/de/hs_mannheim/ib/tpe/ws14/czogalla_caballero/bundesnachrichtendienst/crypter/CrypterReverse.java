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
 * @author 1414163
 *
 */
public class CrypterReverse  extends CrypterBasis implements Crypter{


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

	

}
