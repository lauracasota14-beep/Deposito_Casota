package DesignPatternStrategy2;

import java.util.List;

public class TestFormattazione {
	public static void main(String[] args) {
		
		String testo = "bella bro";
		
		List<Formattazione> strategie = List.of(
				new Maiuscolo(),
				new MaiuscoloPrimaLettera(),
				new AlContrario()
			);
		
		for(Formattazione strategia : strategie) {
			System.out.println(strategia.applica(testo));
		}
	}
}
