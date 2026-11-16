public class Tavoletta extends Cioccolato{
    private int peso;
    private String aggiunte;

    public Tavoletta(String tipo, double percentualeCacao, int peso, String aggiunte) {
        super(tipo, percentualeCacao);

        if(peso >= 4 && peso <= 24){
            this.peso = peso;
        }else {
            System.out.println("Peso non valido.");
            this.peso = 4;
        }

        this.aggiunte = aggiunte;
    }

    @Override 
    public void produce(){
        super.produce();
        System.out.println("Peso: " + peso);
        System.out.println("Aggiunte: " + aggiunte);
        System.out.println("Consumo " + getConsumoCacao());
    }

    public int getConsumoCacao(){
        return peso;
    }
}
