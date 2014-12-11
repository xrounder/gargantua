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

	
	public void createCrypter(CryptionMethod auswahl) throws IllegalKeyException{
		
		switch (auswahl){
			case CAESAR:
				break;
			case SUBSTITUTION:
				break;
			case REVERSE:
				break;
			case XOR:
				break;
			case NULL:
				break;
		}
	}
}
