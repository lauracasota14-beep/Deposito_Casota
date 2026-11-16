//eredità la classe Cioccolato
public class CioccolataCalda extends Cioccolato{

    private double temperatura;
    private double densita;

    //costruttore con inizializzazionne dei parametri
    public CioccolataCalda(String tipo, double percentualeCacao, double temperatura, double densita){
        super(tipo, percentualeCacao);
        this.temperatura = temperatura;
        this.densita = densita;
    }

    @Override 
    public void produce(){
        super.produce();
        System.out.println("Temperatura " + temperatura);
        System.out.println("Densità " + densita);
        System.out.println("Consumo " + getConsumoCacao() + " di ciocccolato");
    }

    //per ogni prozione utilizza 20 grammi di cioccolato (minimo come nella traccia)
    public int getConsumoCacao(){
        return 20;
    }
}
