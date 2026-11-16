
package DesignPatternObserver2;

public class Main {
	public static void main(String[] args) {
		
		Palestra palestra = new Palestra();
		
		Observer log = new Log();
		Observer reception = new Reception();
		
		palestra.addObserver(log);
		palestra.addObserver(reception);
		
		palestra.regis
	}
}
