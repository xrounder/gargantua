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

	
	private String key;
	
	public CrypterCaesar(String key){
		
		this.key = key;
		
	}

		
	private int cryptedPosition(){
		
		int cryptedPos = 0;
		
		while(!key.equals(ALPHABET.charAt(cryptedPos))){
			
			cryptedPos++;
		}
		
		return cryptedPos;
	}

	
	private int letterPosition(char letter){
		
		int letterPos = 0;
		
		while(letter !=ALPHABET.charAt(letterPos)){
				
			letterPos++;
		}	

		return letterPos;
	}
	
	
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		List<String> cryptedMessages = new ArrayList<>();
		
		for (String message : messages) {
		
			cryptedMessages.add(encrypt(message));
		
		}
		
		return cryptedMessages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		cypherText = removeChars(cypherText);
		
		char cryptedLetter;
		String cryptedMessage = "";
		int cryption = cryptedPosition();
			
		for(int posMsg = 0; posMsg < cypherText.length(); posMsg++){
			
			cryption += letterPosition(cypherText.charAt(posMsg));
			
			if(cryption < 2){
							
				cryptedLetter = ALPHABET.charAt(Math.abs(cryption-25));
							
			}else{
				
				cryptedLetter = ALPHABET.charAt(cryption);
		
			}
						
			cryptedMessage += cryptedLetter;
						
		}
		
		return cryptedMessage;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		
		List<String> decryptedMessages = new ArrayList<>();
		
		for (String message : cypherTexte) {
		
			decryptedMessages.add(decrypt(message));
		
		}
		return decryptedMessages;
	}

	@Override
	public String encrypt(String message) throws CrypterException {

		message = removeChars(message);
		
		char cryptedLetter;
		String cryptedMessage = "";
		int cryption = cryptedPosition();
			
		for(int posMsg = 0; posMsg < message.length(); posMsg++){
			
			cryption += letterPosition(message.charAt(posMsg));
			
			if(cryption > 22){
							
				cryptedLetter = ALPHABET.charAt(Math.abs(cryption-25));
							
			}else{
				
				cryptedLetter = ALPHABET.charAt(cryption);
		
			}
						
			cryptedMessage += cryptedLetter;
						
		}
			
		return cryptedMessage;
	}

}
