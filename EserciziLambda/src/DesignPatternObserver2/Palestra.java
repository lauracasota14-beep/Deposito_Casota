package DesignPatternObserver2;

import java.util.ArrayList;
import java.util.List;

public class Palestra implements Subject{
	
	private final List<Observer> observers = new ArrayList<>();
	
	@Override
	public void addObserver(Observer obs) {
		
		observers.add(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		
		observers.remove(obs);
	}
	@Override
	public void notifyObserver(Observer obs) {
		for(Observer obs : observers) {
			obs.update(evento);
		}
	}
}
