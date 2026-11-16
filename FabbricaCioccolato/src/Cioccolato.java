public class Cioccolato{

    private String tipo;
    private double percentualeCacao;
    private int consumoCacao;

    public Cioccolato(String tipo, double percentualeCacao){
        this.tipo = tipo;
        this.percentualeCacao = percentualeCacao;
        this.consumoCacao = 0;
    }

    public void produce(){
        System.out.println("Tipo del cioccolato: " + tipo);
        System.out.println("Percentuale di cacao: " + percentualeCacao);
    }

    public int getConsumoCacao(){
        return consumoCacao;
    }
}