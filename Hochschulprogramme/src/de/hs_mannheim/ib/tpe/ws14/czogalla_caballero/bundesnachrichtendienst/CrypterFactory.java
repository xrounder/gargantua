/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

/**
 * @author 1414163
 *
 */
public class CrypterFactory {

	
	public Crypter createCrypter(CryptionMethod option, String text, String key) throws IllegalKeyException{
		
		Crypter returnCrypter;
		
		switch (option){
			case CAESAR:
				returnCrypter = new CrypterCaesar(text, key);
				break;
			case SUBSTITUTION:
				returnCrypter = new CrypterSubstitution(text, key);
				break;
			case REVERSE:
				returnCrypter = new CrypterReverse(text, key);
				break;
			case XOR:
				returnCrypter = new CrypterXOR(key);
				break;
			case NULL:
				returnCrypter = new CrypterNull(key);
				break;
			default:;
				//IllegalKeyException();
				
		}
		return returnCrypter;
	}
}
