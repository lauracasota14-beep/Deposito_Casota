package DesignPatternObserver2;

public class Reception implements Observer{
	
	public void update(IngressoSocio evento) {
		
		if(evento.abbonamentoScaduto()) {
			
			System.out.println("Reception abbonamento scaduto per " + evento.nome());
		}
	}
}
