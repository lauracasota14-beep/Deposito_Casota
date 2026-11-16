package esercizi.lambda;

import java.util.Arrays;
import java.util.List;

public class Esercizio1 {
	public static void main(String[] args) {
		
		//Crea la lista con nm int
		List<Integer> numeri = List.of(1, 2, 7);
		
		//per ogni elemento stampa il valore x2
		numeri.forEach(numero -> System.out.println(numero * 2));
		
		String[] parole = {"mondo", "a", "ciao"};
		Arrays.sort(parole, (x,y) -> Integer.compare(x.length(), y.length()));
		
		System.out.println(Arrays.toString(parole));
	}
}
