package eserciziCollection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class IncassoCinema {
	public static void main (String[] args) {
		
		// TreeMap mantine i titoli in ordine alfabetico
		Map<String, Double> ordineAlfa = new TreeMap<>();
		
		//Linked mantiene invece ordine di primo inserimento dei titoli
		Map<String, Double> ordineArrivo = new LinkedHashMap<>();
		
		
		//put chiave valore
		ordineAlfa.put("Gladiatore", 2200.0);
		ordineAlfa.put("Avengers", 1500.0);
		ordineAlfa.put("Scream", 1800.0);
		
		ordineArrivo.put("Scream", 1800.0);
		ordineArrivo.put("Avengers", 1500.0);
		ordineArrivo.put("Gladiatore", 2200.0);
		
		System.out.println("Ordine aflabetico");
		System.out.println(ordineAlfa);
		
		System.out.println("Ordine di arrivo");
		System.out.println(ordineArrivo);
	}
}
