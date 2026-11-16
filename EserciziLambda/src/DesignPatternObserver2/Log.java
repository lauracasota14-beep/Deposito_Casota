package DesignPatternObserver2;

public class Log implements Observer{
	
	public void update(IngressoSocio evento) {
		System.out.println("Log, ingresso di " + evento.nome());
	}
}
