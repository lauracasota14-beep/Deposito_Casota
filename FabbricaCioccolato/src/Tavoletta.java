public class Tavoletta extends Cioccolato{
    private int peso;
    private String aggiunte;

    public Tavoletta(String tipo, double percentualeCacao, int peso, String aggiunte) {
        super(tipo, percentualeCacao);

        //accetto il peso solo se compreso tra i nm
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

    //qui consider i l consumo uguale al peso
    public int getConsumoCacao(){
        return peso;
    }
}
