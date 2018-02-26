package com.Register;

import java.util.HashMap;

/**
 * Clasele de tip BH sunt folosite in cadrul proiectului ca si clase pentru operarea de metode DB precum INSERT, UPDATE, DELETE.
 * @author Stefan
 * @version 0.1
 */
public class RegisterBH {

	public static String verificareParole(String parolaFirst, String parolaSecond) {
		// TODO Metoda ce verifica daca parole sunt egale din toate punctel de vedere daca nu sa arunce o exceptie ca parole nu sunt egale
		String parolaCriptata = criptareParola(parolaFirst);
		return parolaCriptata;
	}

	private static String criptareParola(String parolaSecond) {
		// TODO Metoda ce sa cripteze parola
		return parolaSecond;
	}
	
	private static String decriptareParola(String parolaSecond) {
		// TODO Metoda ce sa decripteze parola
		return parolaSecond;
	}

	public static HashMap<String, String> splitNumeSiPrenume(String numeSiPrenumeStr) {
		// TODO Metoda ce sa creze un HashMap cu 2 chei 'nume' si 'prenume' , se arunca si excepti unde este cazul.
		return null;
	}
}
