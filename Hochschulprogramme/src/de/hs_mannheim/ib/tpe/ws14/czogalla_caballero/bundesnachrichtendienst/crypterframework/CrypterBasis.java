package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

public abstract class CrypterBasis {

	protected final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	protected String key;
	
	public CrypterBasis(String key){
		
		this.key = key;
		
	}
	
	public CrypterBasis(){
		
		
	}
	
	public String getAlphabet(){
		
		return ALPHABET;
	}
	
	//entfernt alle ungültigen/nicht erlaubten Zeichen aus dem String
	protected String removeChars(String text){
		
		text = text.trim();
		text = text.toUpperCase();
		String removed = "";
		
		for(int pos = 0; pos < text.length(); pos++){
			
			for(int posAlph = 0; posAlph < ALPHABET.length(); posAlph++){
				
				if(text.charAt(pos) == ALPHABET.charAt(posAlph)){
					
					removed += text.charAt(pos);
					
				}
				
			}
			
		}
		
		return removed;
	}
	
	public abstract String encrypt(String message) throws CrypterException; 
	
	public abstract String decrypt(String cypherText) throws CrypterException;
	
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		List<String> cryptedMessages = new ArrayList<>();
		
		for (String message : messages) {
		
			cryptedMessages.add(encrypt(message));
		
		}
		
		return cryptedMessages;
	}
	
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException{
	List<String> cryptedMessages = new ArrayList<>();
	
	for (String cypherText : cypherTexte) {
	
		cryptedMessages.add(decrypt(cypherText));
	
	}
	
	return cryptedMessages;
	}
	
	
}
