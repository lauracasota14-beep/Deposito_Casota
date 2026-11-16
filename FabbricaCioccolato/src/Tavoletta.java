public class Tavoletta extends Cioccolato{
    private String peso;
    private String aggiunte;

    public Tavoletta(String tipo, double percentualeCacao, int peso, String aggiunte) {
        super(tipo, percentualeCacao);

        if(peso -< 4 && peso <= 24){
            this.peso = peso;
        }else {
            System.out.println("Peso non valido.");
            this.peso = 4;
        }
    }
}
