public class Cioccolato{

    private String tipo;
    private double percentualeCacao;
    private int consumoCacao;

    //quandp creo prodotto, salvo tipo e % di cacaco
    public Cioccolato(String tipo, double percentualeCacao){
        this.tipo = tipo;
        this.percentualeCacao = percentualeCacao;
        this.consumoCacao = 0;
    }

    //stampo le informazioni del cioccolato
    public void produce(){
        System.out.println("Tipo del cioccolato: " + tipo);
        System.out.println("Percentuale di cacao: " + percentualeCacao);
    }

    //il consumo di cacao è 0 
    public int getConsumoCacao(){
        return consumoCacao;
    }
}