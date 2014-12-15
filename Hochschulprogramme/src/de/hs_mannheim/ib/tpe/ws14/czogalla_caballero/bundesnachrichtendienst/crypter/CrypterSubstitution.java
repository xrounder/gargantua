package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

public class CrypterSubstitution extends CrypterBasis implements Crypter{

	private String key;
	
	public CrypterSubstitution(String key){
		
		if(key.length() == 26){
			this.key = key;
		}
		
	}
	
	
	
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		message = removeChars(message);
		String crypted = "";
		
		
		for(int pos = 0; pos < message.length(); pos++){
			
			for(int posKey = 0; posKey < key.length(); posKey++){
				
				if(message.charAt(pos) == ALPHABET.charAt(posKey)){
					
					crypted += key.charAt(posKey);
					
				}
					
			}
		}
		
		return crypted;
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
		String crypted = "";
		
		for(int pos = 0; pos < cypherText.length(); pos++){
			
			for(int posKey = 0; posKey < key.length(); posKey++){
				
				if(cypherText.charAt(pos) == key.charAt(posKey)){
					
					crypted += ALPHABET.charAt(posKey);
				}
					
			}
		}
		
		
		return crypted;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		List<String> cryptedMessages = new ArrayList<>();
		
		for (String message : cypherTexte) {
		
			cryptedMessages.add(decrypt(message));
		
		}
		
		return cryptedMessages;
	
	}

}
