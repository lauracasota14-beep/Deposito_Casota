package DesignPatternStrategy1;

public class TestParcheggio {

	public static void main(String[] args) {
		//dichiara la var che usa l'interface e oggetto
		PagamentoParcheggio pagamento = new PagamentoOrario();
		
		System.out.println("pagamento ad ora " + pagamento.calcolaPrezzo(3));
		
		pagamento = new PagamentoGiornaliero();
		System.out.println("pagamento giorno " + pagamento.calcolaPrezzo(5));
	}

}
