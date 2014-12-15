package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework;

import java.util.ArrayList;
import java.util.List;

public abstract class CrypterBasis {

	protected final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public CrypterBasis(){
		
		
	}
	
	public String getAlphabet(){
		
		return ALPHABET;
	}
	
	protected String removeChars(String text){
		
		text.trim();
		text.toUpperCase();
		
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
	
	
}
