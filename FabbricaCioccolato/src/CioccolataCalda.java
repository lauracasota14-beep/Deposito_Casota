public class CioccolataCalda extends Cioccolato{

    private double temperatura;
    private double densita;

    public CioccolataCalda(String tipo, double percentualeCacao, double temperatura, double densita){
        super(tipo, percentualeCacao);
        this.temperatura = temperatura;
        this.densita = densita;
    }
}
