package DesignPatternStrategy1;

public class PagamentoOrario implements PagamentoParcheggio {
	
	public double calcolaPrezzo(int ore) {
		return ore * 2.0;
	}
}
