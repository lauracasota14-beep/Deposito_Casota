public class Cioccolatino extends Cioccolato{

    private String forma;
    private String ripieno;

    private static final int consumoCacao = 10;

    public Cioccolatino(String tipo, double percentualeCacao, String forma, String ripieno){

        super(tipo, percentualeCacao);
        this.forma = forma;
        this.ripieno = ripieno;
    }

    @Override 
    public void produce(){
        super.produce();
        System.out.println("Forma: " + forma);
        System.out.println("Ripieno: " + ripieno);
        System.out.println("Consumo di cacao: " + consumoCacao);
    }

    public int getConsumoCacao(){
        return consumoCacao;
    }
}
