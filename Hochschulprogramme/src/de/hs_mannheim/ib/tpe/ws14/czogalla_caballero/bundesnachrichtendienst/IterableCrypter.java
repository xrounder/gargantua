package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;

public class IterableCrypter implements Iterable<String>{

	private List<String> arrList = new ArrayList<>();
	private Crypter crypter;
	
	public IterableCrypter(List<String> arrList, Crypter crypter){
		
		this.arrList = arrList;
		this.crypter = crypter;
		
	}
}
