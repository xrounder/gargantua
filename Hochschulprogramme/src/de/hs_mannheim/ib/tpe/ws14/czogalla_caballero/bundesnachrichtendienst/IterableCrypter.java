package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.Iterator;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;

public class IterableCrypter implements Iterable<String>{

	private Iterable<String> list;
	private Crypter crypter;
	
	public IterableCrypter(Iterable<String> iterableCrypter, Crypter crypter){
		
		this.list = iterableCrypter;
		this.crypter = crypter;
		
	}
	
	
	
	@Override
	public Iterator<String> iterator() {
		
		
		return null;
	}
}
