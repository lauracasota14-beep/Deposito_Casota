public class Cioccolatino extends Cioccolato{

    private String forma;
    private String ripieno;

    //consuma 2 unita di cioccolato
    private static final int consumoCacao = 2;

    public Cioccolatino(String tipo, double percentualeCacao, String forma, String ripieno){

        super(tipo, percentualeCacao);

        //salvo le forma e
        this.forma = forma;
        this.ripieno = ripieno;
    }

    //stampo le informazioni 
    @Override 
    public void produce(){
        super.produce();
        System.out.println("Forma: " + forma);
        System.out.println("Ripieno: " + ripieno);
        System.out.println("Consumo di cacao: " + consumoCacao);
    }

    //consumo del cioccolatino
    public int getConsumoCacao(){
        return consumoCacao;
    }
}
