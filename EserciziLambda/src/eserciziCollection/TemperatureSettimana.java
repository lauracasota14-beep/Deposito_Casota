package eserciziCollection;

public class TemperatureSettimana {

	public static void main(String[] args) {
        double[] temperature = {12.5, 15.0, 9.8, 18.2, 14.0, 11.3, 16.7};
        
        String[] giorni = {
        		"Luned'", "Martedì", "Mercoledi", "Giovedì", "Venerdì", "Sabato", "Domenica"
        };
        
        double massima = temperature[0];
        int indiceMassima = 0;
        
        //parte da martedì, continua finche l'indice è dentro 
        //l'array e passa alla successiva.
        for (int i = 1; i < temperature.length; i++) 
        {
        	//se trova temperatura più alta aggiorna il massimo
        	// e posizione
        	if(temperature[i] > massima) 
        	{
        		massima = temperature[i];
        		indiceMassima = i;
        	}
        }
        
        System.out.println("Temperatura max " + massima);
        System.out.println("Giorno " + giorni[indiceMassima]);
	}

}
