/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter.CrypterCaesar;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter.CrypterNull;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter.CrypterReverse;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter.CrypterSubstitution;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter.CrypterXOR;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

/**
 * @author 1414163
 *
 */
public class CrypterFactory {
	


	public static Crypter createCrypter(String key,CryptionMethod option) throws IllegalKeyException{
		
		
		Crypter returnCrypter = null;
		
		switch (option){
			case CAESAR:
				returnCrypter = new CrypterCaesar(key);
				break;
			case SUBSTITUTION:
				returnCrypter = new CrypterSubstitution(key);
				break;
			case REVERSE:
				returnCrypter = new CrypterReverse();
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
