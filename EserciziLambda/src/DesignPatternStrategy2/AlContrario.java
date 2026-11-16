package DesignPatternStrategy2;

public class AlContrario implements Formattazione{
	
	public String applica(String testo) {
		return new StringBuilder(testo) //crea un oggettp
				.reverse()
				.toString();
	}
}
