package DesignPatternStrategy2;

public class Maiuscolo implements Formattazione{
	
	public String applica(String testo) {
		
		return testo.toUpperCase();
	}
}
