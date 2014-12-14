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
public class CrypterXOR implements Crypter{

	private String key;
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@[\\]^_";

	public CrypterXOR(String key){
		this.key = key;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		String crypted = "";
		
		if(message.length() > key.length()){
			
			int missing = message.length() - key.length();
			
			for(int pos = 0; pos < missing; pos++){
				
				key += key.charAt(pos); 
			}
			
		}
		
		for(int pos = 0; pos < message.length(); pos++){
			
			int keyValue = 0;
			int textValue = 0;
			
			for(int posKey = 0; posKey < ALPHABET.length(); posKey++){
			
				if(message.charAt(pos) == ALPHABET.charAt(posKey)){
					
					textValue = posKey;
				}
				
				if(key.charAt(pos) == ALPHABET.charAt(posKey)){
					
					keyValue = posKey;
				}
					
			}
			
			crypted += ALPHABET.charAt(keyValue ^ textValue);
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
			
			int keyValue = 0;
			int textValue = 0;
			
			for(int posKey = 0; posKey < ALPHABET.length(); posKey++){
			
				if(cypherText.charAt(pos) == ALPHABET.charAt(posKey)){
					
					textValue = posKey;
				}
				
				if(key.charAt(pos) == ALPHABET.charAt(posKey)){
					
					keyValue = posKey;
				}
					
			}
			
			crypted += ALPHABET.charAt(keyValue ^ textValue);
		}
		

		return crypted;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException{
	List<String> cryptedMessages = new ArrayList<>();
	
	for (String message : cypherTexte) {
	
		cryptedMessages.add(decrypt(message));
	
	}
	
	return cryptedMessages;
	}

}
