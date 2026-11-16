package esercizi.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Esercizio2 {

	public static void main(String[] args) {
        List<String> frutta = new ArrayList<>(
                List.of("kiwi", "banana", "mela", "ananas",
                        "pera", "fico", "arancia"));
        
        //interfaccia funzionale che riceve un valore e compie un'azione
        //senza restituire un risultato
        Consumer<String> stampa = parola -> System.out.println(parola);
        
        frutta.forEach(stampa);
        
        //Serve a verificare una condizione e restituisce un bool.
        Predicate<String> corta = parola -> parola.length() <= 4;
        
        frutta.removeIf(corta);
        
        Comparator<String> ordinamento = (a, b) ->{
        	int confronto = Integer.compare(b.length(), a.length());
        	
        	if(confronto == 0) {
        		return a.compareTo(b);
        	}
        	
        	return confronto;
        };
        
        frutta.sort(ordinamento);
        
        System.out.println("---");
        frutta.forEach(stampa);
	}

}
