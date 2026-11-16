package esercizi.lambda;

import java.util.Comparator;
import java.util.List;

public class Esercizio3 {
	
	public record Ordine(String cliente, String prodotto, int quantita, double prezzoUnitario) {
		
		public double totale() {
			return quantita * prezzoUnitario;
		}
	}

	public static void main(String[] args) {
		List <Ordine> ordini = List.of(
				
                new Ordine("Anna", "Mouse", 2, 25.0),
                new Ordine("Luca", "Monitor", 1, 199.0),
                new Ordine("Anna", "Tastiera", 1, 45.0),
                new Ordine("Marta", "Mouse", 3, 25.0),
                new Ordine("Luca", "Webcam", 2, 60.0),
                new Ordine("Paolo", "Monitor", 2, 199.0));
		
		
		//nomi prodotti ordine alfabetico
		List<String> prodotti = ordini.stream()
				.map(ordine -> ordine.prodotto())
				.sorted()
				.toList();
			
		System.out.println(prodotti);
		
		//calcolo totaleincasso
		double totaleIncassato = ordini.stream()
				.mapToDouble(ordine -> ordine.totale())
				.sum();
		
		System.out.println("Totale incassato " + totaleIncassato);
		
		//cercare i clienti con ordine superiore a 100
		List<String> clienti = ordini.stream()
				.filter(ordine -> ordine.totale() > 100)
				.map(ordine -> ordine.cliente())
				.sorted()
				.toList();
		
		System.out.println(clienti);
		
		//ordine totale più alto
		String ordineMassimo = ordini.stream()
				.max(Comparator.comparingDouble(ordine -> ordine.totale()))
				.map(ordine -> ordine.cliente() + " - " + ordine.prodotto())
				.orElse("Nessun ordine");
		
		System.out.println(ordineMassimo);
		
	}
}
