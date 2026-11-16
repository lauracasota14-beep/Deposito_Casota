import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

	public static void main(String[] args) {
		List<? extends Number> numbers = new ArrayList<Integer>();
		List<? super Integer> integers = new ArrayList<Number>();
		

// Covarianza - Posso leggere valori poiche numbers e un'es
		Number number = numbers.get(0);

// Controvarianza - Posso aggiungere valori poiche integers
		integers.add(42);
		integers.add(23);
		integers.add(15);
	}
}
