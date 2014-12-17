package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter.CrypterSubstitution;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterFactory;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CryptionMethod;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;


public class Testklasse {

	
	public static void main(String[] args) throws CrypterException {


		/*
		Crypter sub = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CryptionMethod.SUBSTITUTION);
		Crypter caes = CrypterFactory.createCrypter("L", CryptionMethod.CAESAR);
		Crypter rev = CrypterFactory.createCrypter("", CryptionMethod.REVERSE);
		Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CryptionMethod.XOR);
		
		String crypted = sub.decrypt(caes.decrypt(rev.decrypt(xor.decrypt("QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X"))));
		System.out.println(crypted);
		*/
	
		Crypter xor = CrypterFactory.createCrypter("TPERULES",CryptionMethod.XOR);
		Crypter rev = CrypterFactory.createCrypter("abcdefg",CryptionMethod.REVERSE);
		Crypter sub = CrypterFactory.createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI", CryptionMethod.SUBSTITUTION);
		Crypter caes = CrypterFactory.createCrypter("C", CryptionMethod.CAESAR);
		
		
		
		
		System.out.println(rev.decrypt(rev.encrypt("asc12 VAS")));
		System.out.println(sub.decrypt(sub.encrypt("WIKIPEDIAISTINFORMATIV")));
		System.out.println(xor.decrypt(xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
		System.out.println(caes.decrypt(caes.encrypt("CAESAR")));
	
		
		/*
	
		Crypter rev = CrypterFactory.createCrypter("U", CryptionMethod.REVERSE);
		Crypter xor = CrypterFactory.createCrypter("TPERULES", CryptionMethod.XOR);
		List<String> liste = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "IST", "EIN", "TEST");
		IterableCrypter iterableCrypter = new IterableCrypter(new IterableCrypter(liste, xor), rev);
		for (String cypherText : iterableCrypter) {
		System.out.println(cypherText);
		}*/
	}

}