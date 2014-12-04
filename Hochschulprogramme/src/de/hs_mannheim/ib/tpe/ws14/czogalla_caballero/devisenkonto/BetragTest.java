package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.devisenkonto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit-Test zur Klasse Betrag
 * 
 * @see de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.Devisenkonto.Betrag
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
public class BetragTest {

	Waehrungen testwaehrungen = new Waehrungen();

	Betrag betrag = new Betrag(testwaehrungen.usDollar, 52.33);

	Betrag betrag1 = new Betrag(testwaehrungen.euro, 12.42);

	Betrag betrag2 = new Betrag(testwaehrungen.rubel, -32.11);

	Betrag betrag3 = new Betrag(testwaehrungen.schweizerFranken, 0.01);

	/**
	 * testet die Methode addiere
	 */
	@Test
	public void testAddiere() {
		assertEquals(10466, betrag.addiere(betrag).getBetrag());
		assertEquals(2484, betrag1.addiere(betrag1).getBetrag());
		assertEquals(-6422, betrag2.addiere(betrag2).getBetrag());
		assertEquals(2, betrag3.addiere(betrag3).getBetrag());

	}

	/**
	 * testet die Methode subtrahiere
	 */
	@Test
	public void testSubtrahiere() {
		assertEquals(0, betrag.subtrahiere(betrag).getBetrag());
		assertEquals(0, betrag1.subtrahiere(betrag1).getBetrag());
		assertEquals(-4453, betrag2.subtrahiere(betrag1).getBetrag());
		assertEquals(0, betrag3.subtrahiere(betrag3).getBetrag());
	}

	/**
	 * testet die Methode multipliziere in double und long
	 */
	@Test
	public void testMultipliziere() {
		assertEquals(111672, betrag.multipliziere(21.34).getBetrag());
		assertEquals(0, betrag1.multipliziere(0.00).getBetrag());
		assertEquals(-12844, betrag2.multipliziere(4).getBetrag());
		assertEquals(23, betrag3.multipliziere(23).getBetrag());
	}

	/**
	 * testet die Methode prozent
	 */
	@Test
	public void testProzent() {
		assertEquals(1116, betrag.prozent(21.34).getBetrag());
		assertEquals(12, betrag1.prozent(1).getBetrag());
		assertEquals(-4816, betrag2.prozent(150).getBetrag());
		assertEquals(0, betrag3.prozent(0).getBetrag());
	}

	/**
	 * testet die Methode promille
	 */
	@Test
	public void testPromille() {
		assertEquals(111, betrag.promille(21.34).getBetrag());
		assertEquals(1, betrag1.promille(1).getBetrag());
		assertEquals(-481, betrag2.promille(150).getBetrag());
		assertEquals(0, betrag3.promille(0).getBetrag());
	}

	/**
	 * testet die Methode getVorkomma
	 */
	@Test
	public void testGetVorkomma() {
		assertEquals(52, betrag.getVorkomma());
		assertEquals(12, betrag1.getVorkomma());
		assertEquals(32, betrag2.getVorkomma());
		assertEquals(0, betrag3.getVorkomma());
	}

	/**
	 * testet die Methode getNachkomma
	 */
	@Test
	public void testGetNachkomma() {
		assertEquals(33, betrag.getNachkomma());
		assertEquals(42, betrag1.getNachkomma());
		assertEquals(11, betrag2.getNachkomma());
		assertEquals(01, betrag3.getNachkomma());
	}

	/**
	 * testet die Methode toString
	 */
	@Test
	public void testToString() {
		assertEquals("52,33 $", betrag.toString());
		assertEquals("12,42 €", betrag1.toString());
		assertEquals("-32,11 RUB", betrag2.toString());
		assertEquals("0,01 CHF", betrag3.toString());
	}

	/**
	 * testet die Methode getAsDouble
	 */
	@Test
	public void testGetAsDouble() {
		assertEquals(52.33, betrag.getAsDouble(), 0.0);
		assertEquals(12.42, betrag1.getAsDouble(), 0.0);
		assertEquals(-32.11, betrag2.getAsDouble(), 0.0);
		assertEquals(0.01, betrag3.getAsDouble(), 0.0);
	}

	/**
	 * testet die Methode getVorzeichen
	 */
	@Test
	public void testGetVorzeichen() {
		assertEquals(1, betrag.getVorzeichen());
		assertEquals(1, betrag1.getVorzeichen());
		assertEquals(-1, betrag2.getVorzeichen());
		assertEquals(1, betrag3.getVorzeichen());
	}

}
