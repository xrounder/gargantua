/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * @author 1414163
 *
 */
public class CrypterCaesar implements Crypter{

	
	private final String[] ALPHABET = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
	private String key;
	
	public CrypterCaesar(String key){
		
		this.key = key;
		
	}

	private String encryptMessage(String message){
		
		String cryptedLetter;
		String cryptedMessage = "";
		
		for(int posAlphabet = 0; posAlphabet < ALPHABET.length; posAlphabet++){
			
			if(key.equals(ALPHABET[posAlphabet].charAt(posAlphabet))){
				
				if(posAlphabet > 22){
					
					cryptedLetter = ALPHABET[Math.abs(posAlphabet-25)];
					
				}else{
					
					cryptedLetter = ALPHABET[posAlphabet];
				}
				
				cryptedMessage += cryptedLetter;
				
			}
		
		}
		
		return cryptedMessage;
	}
	
	private String decryptMessage(String message){
		
		String cryptedLetter;
		String cryptedMessage = "";
		
		for(int posAlphabet = 0; posAlphabet < ALPHABET.length; posAlphabet++){
			
			if(key.equals(ALPHABET[posAlphabet].charAt(posAlphabet))){
				
				if(posAlphabet < 2){
					
					cryptedLetter = ALPHABET[Math.abs(posAlphabet-25)];
					
				}else{
					
					cryptedLetter = ALPHABET[posAlphabet];
				}
				
				cryptedMessage += cryptedLetter;
				
			}
		
		}
		
		return cryptedMessage;
	}

	
	
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		List<String> cryptedMessages = new ArrayList<>();
		
		for (String message : cryptedMessages) {
		
			cryptedMessages.add(encryptMessage(message));
		
		}
		
		return cryptedMessages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return decryptMessage(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		
		List<String> decryptedMessages = new ArrayList<>();
		
		for (String message : decryptedMessages) {
		
			decryptedMessages.add(decryptMessage(message));
		
		}
		return decryptedMessages;
	}

	@Override
	public String encrypt(String message) throws CrypterException {

		return encryptMessage(message);
	}

}
