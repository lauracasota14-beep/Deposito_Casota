public class Cioccolato{

    private String tipo;
    private double percentualeCacao;

    public Cioccolato(String tipo, double percentualeCacao){
        this.tipo = tipo;
        this.percentualeCacao = percentualeCacao;
    }

    public void produce(){
        System.out.println("Tipo del cioccolato: " + tipo);
        System.out.println("Percentuale di cacao: " + percentualeCacao);
    }
}