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
public class CrypterCaesar extends CrypterBasis implements Crypter{

	
	
	public CrypterCaesar(String key){
		
		super(key);
		
	}

		
	private int cryptedPosition(){
		
		int cryptedPos = 0;

		for(int pos = 0; pos < ALPHABET.length(); pos++){
			
			if(key.charAt(0) == ALPHABET.charAt(pos)){
				
				cryptedPos = pos+1;
			}
			
			
		}
	
		return cryptedPos;
	}

	
	
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		cypherText = removeChars(cypherText);
		String cryptedMessage = "";
		char cryptedLetter;	
		
		int cryptedPos = cryptedPosition();
		
		for(int posMsg = 0; posMsg < cypherText.length(); posMsg++){
		
			for(int letterPos = 0; letterPos < ALPHABET.length(); letterPos++){
				
				if(cypherText.charAt(posMsg) == ALPHABET.charAt(letterPos)){
					
					if(letterPos-cryptedPos < 0){
					
						cryptedLetter = ALPHABET.charAt(ALPHABET.length() - Math.abs(letterPos-cryptedPos));
	
					}else{
						
						cryptedLetter =  ALPHABET.charAt(letterPos-cryptedPos);
						
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
		
		for(int posMsg = 0; posMsg < message.length(); posMsg++){
		
			for(int letterPos = 0; letterPos < ALPHABET.length(); letterPos++){
				
				if(message.charAt(posMsg) == ALPHABET.charAt(letterPos)){
					
					if(letterPos+cryptedPos > ALPHABET.length()-1){
						
						cryptedLetter = ALPHABET.charAt(letterPos+cryptedPos-ALPHABET.length());
						
					}else{
						
						cryptedLetter =  ALPHABET.charAt(letterPos+cryptedPos);
						
					}
					
					cryptedMessage += cryptedLetter;
					
				}
				
			}
			
			
			
						
		}
			
		return cryptedMessage;
	}

}
