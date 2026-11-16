package DesignPatternObserver1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleConsumer;

public class Termometro {
	private final List<DoubleConsumer> osservatori = new ArrayList<>();
	
	public void iscrivi(DoubleConsumer osservatore) {
		osservatori.add(osservatore);
	}
	
	public void registra(double temperatura) {
		for(DoubleConsumer osservatore: osservatori) {
			osservatore.accept(temperatura);
		}
	}
}
