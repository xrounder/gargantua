package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.Iterator;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
/**
 *  @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * 
 */
public class IterableCrypter implements Iterable<String>{

	private Iterable<String> list;
	private Crypter crypter;
	
	public IterableCrypter(Iterable<String> iterableCrypter, Crypter crypter){
	
		this.list = iterableCrypter;
		this.crypter = crypter;
		
	}
	
	
	/**
	 * Iterator zum Durchlaufen der Liste
	 * 
	 */
	@Override
	public Iterator<String> iterator(){
		
		return new Iterator<String>(){

			Iterator<String> iterator = list.iterator();
			
			@Override
			public boolean hasNext() {
				
				return iterator.hasNext();
			}

			@Override
			public String next() {
					
				try {
					return crypter.encrypt(iterator.next());
						
				} catch (CrypterException e) {
						
					e.printStackTrace();
				}
			
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}

			
		};
	}
	
}
