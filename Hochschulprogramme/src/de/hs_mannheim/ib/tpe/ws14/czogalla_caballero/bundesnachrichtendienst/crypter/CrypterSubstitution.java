package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

public class CrypterSubstitution implements Crypter{

	private String key;
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public CrypterSubstitution(String key){
		
		if(key.length() == 26){
			this.key = key;
		}
		
	}
	
	
	
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
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
