/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * @author 1414163
 *
 */
public class CrypterCaesar implements Crypter{

	
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String key;
	
	public CrypterCaesar(String key){
		
		this.key = key;
		
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
		
		char cryptedLetter;
		String cryptedMessage = "";
		
		for(int posAlphabet = 0; posAlphabet < ALPHABET.length(); posAlphabet++){
			
			if(key.equals(ALPHABET.charAt(posAlphabet))){
				
				if(posAlphabet < 2){
					
					cryptedLetter = ALPHABET.charAt(Math.abs(posAlphabet-25));
					
				}else{
					
					cryptedLetter = ALPHABET.charAt(posAlphabet);
				}
				
				cryptedMessage += cryptedLetter;
				
			}
		
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

		char cryptedLetter;
		String cryptedMessage = "";
		
		for(int posAlphabet = 0; posAlphabet < ALPHABET.length(); posAlphabet++){
			
			if(key.equals(ALPHABET.charAt(posAlphabet))){
				
				if(posAlphabet > 22){
					
					cryptedLetter = ALPHABET.charAt(Math.abs(posAlphabet-25));
					
				}else{
					
					cryptedLetter = ALPHABET.charAt(posAlphabet);
				}
				
				cryptedMessage += cryptedLetter;
				
			}
		
		}
		
		return cryptedMessage;
	}

}
