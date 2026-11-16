public class Cioccolatino extends Cioccolato{

    private String forma;
    private String ripieno;

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
    }
}
