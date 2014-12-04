package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.devisenkonto;

/**
 * Dient als �bersicht bzw. Liste f�r verschiedene W�hrungen
 * 
 * @see de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.Devisenkonto.Waehrung
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
public class Waehrungen {

	public Waehrung usDollar = new Waehrung("US-Dollar", "$", 10000);
	public Waehrung euro = new Waehrung("Euro", "�", 12690);
	public Waehrung yen = new Waehrung("Yen", "�", 91);
	public Waehrung rubel = new Waehrung("Rubel", "RUB", 255);
	public Waehrung schweizerFranken = new Waehrung("Schweizer Franken", "CHF",
			10509);

}
