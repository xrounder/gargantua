/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterFactory;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CryptionMethod;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

/**
 * JUnitTests
 *
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 *
 */
public class CrypterTests {

	@Test
	public void CrypterNullTest() throws CrypterException{
		
		Crypter nul = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CryptionMethod.NULL);
		
		assertTrue(nul.decrypt(nul.encrypt("WARUMBINICHSOFROEHLICH")).equals("WARUMBINICHSOFROEHLICH"));
		assertTrue(nul.decrypt(nul.encrypt("WarumBinIchSoFroehlich")).equals("WARUMBINICHSOFROEHLICH"));
		assertFalse(nul.decrypt(nul.encrypt("WarumBinIchSoFroehlich")).equals("WarumBinIchSoFroehlich"));
		assertFalse(nul.decrypt(nul.encrypt("Waass laaberscht duu??!?!")).equals("Waass laaberscht duu??!?!"));
		assertTrue(nul.decrypt(nul.encrypt("Waass laaberscht duu??!?!")).equals("WAASSLAABERSCHTDUU"));
		
		assertEquals("TEST", nul.encrypt("TEST"));
		assertEquals("TEST", nul.decrypt("TEST"));
		
		
	}

	@Test
	public void CrypterReverseTest() throws CrypterException{
	
		Crypter rev = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CryptionMethod.REVERSE);
		
		assertTrue(rev.decrypt(rev.encrypt("WARUMBINICHSOFROEHLICH")).equals("WARUMBINICHSOFROEHLICH"));
		assertTrue(rev.decrypt(rev.encrypt("WarumBinIchSoFroehlich")).equals("WARUMBINICHSOFROEHLICH"));
		assertFalse(rev.decrypt(rev.encrypt("WarumBinIchSoFroehlich")).equals("WarumBinIchSoFroehlich"));
		assertFalse(rev.decrypt(rev.encrypt("Waass laaberscht duu??!?!")).equals("Waass laaberscht duu??!?!"));
		assertTrue(rev.decrypt(rev.encrypt("Waass laaberscht duu??!?!")).equals("WAASSLAABERSCHTDUU"));
		
		assertEquals("HGFEDCBA", rev.encrypt("ABCDEFGH"));
		assertEquals("ABCDEFGH", rev.decrypt("HGFEDCBA"));
		
	}

	@Test
	public void CrypterXorTest() throws CrypterException{
	
		Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CryptionMethod.XOR);
		
		assertTrue(xor.decrypt(xor.encrypt("WARUMBINICHSOFROEHLICH")).equals("WARUMBINICHSOFROEHLICH"));
		assertTrue(xor.decrypt(xor.encrypt("WarumBinIchSoFroehlich")).equals("WARUMBINICHSOFROEHLICH"));
		assertFalse(xor.decrypt(xor.encrypt("WarumBinIchSoFroehlich")).equals("WarumBinIchSoFroehlich"));
		assertFalse(xor.decrypt(xor.encrypt("Waass laaberscht duu??!?!")).equals("Waass laaberscht duu??!?!"));
		assertTrue(xor.decrypt(xor.encrypt("Waass laaberscht duu??!?!")).equals("WAASSLAABERSCHTDUU"));
		
		Crypter xor2 = CrypterFactory.createCrypter("TPERULES", CryptionMethod.XOR);
		
		assertEquals(xor2.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),"URFVPJB[]ZN^XBJCEBVF@ZRKMJ");
		assertEquals(xor2.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"),"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		

	}
	
	@Test
	public void CrypterCeasarTest() throws CrypterException{
	
		Crypter caes = CrypterFactory.createCrypter("L", CryptionMethod.CAESAR);
		
		assertTrue(caes.decrypt(caes.encrypt("WARUMBINICHSOFROEHLICH")).equals("WARUMBINICHSOFROEHLICH"));
		assertTrue(caes.decrypt(caes.encrypt("WarumBinIchSoFroehlich")).equals("WARUMBINICHSOFROEHLICH"));
		assertFalse(caes.decrypt(caes.encrypt("WarumBinIchSoFroehlich")).equals("WarumBinIchSoFroehlich"));
		assertFalse(caes.decrypt(caes.encrypt("Waass laaberscht duu??!?!")).equals("Waass laaberscht duu??!?!"));
		assertTrue(caes.decrypt(caes.encrypt("Waass laaberscht duu??!?!")).equals("WAASSLAABERSCHTDUU"));
	
		
		Crypter caes2 = CrypterFactory.createCrypter("C", CryptionMethod.CAESAR);
		
		assertEquals(caes2.encrypt("CAESAR"),"FDHVDU");
		assertEquals(caes2.decrypt("FDHVDU"),"CAESAR");
	}
	
	@Test
	public void CrypterSubstitutionTest() throws CrypterException{

		Crypter sub = CrypterFactory.createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI", CryptionMethod.SUBSTITUTION);
		
		assertTrue(sub.decrypt(sub.encrypt("WARUMBINICHSOFROEHLICH")).equals("WARUMBINICHSOFROEHLICH"));
		assertTrue(sub.decrypt(sub.encrypt("WarumBinIchSoFroehlich")).equals("WARUMBINICHSOFROEHLICH"));
		assertFalse(sub.decrypt(sub.encrypt("WarumBinIchSoFroehlich")).equals("WarumBinIchSoFroehlich"));
		assertFalse(sub.decrypt(sub.encrypt("Waass laaberscht duu??!?!")).equals("Waass laaberscht duu??!?!"));
		assertTrue(sub.decrypt(sub.encrypt("Waass laaberscht duu??!?!")).equals("WAASSLAABERSCHTDUU"));
	
		assertEquals(sub.encrypt("WIKIPEDIAISTINFORMATIV"), "ZSMSYWPSUSTESNDQVOUESH");
		assertEquals(sub.decrypt("ZSMSYWPSUSTESNDQVOUESH"), "WIKIPEDIAISTINFORMATIV");
	}

}
