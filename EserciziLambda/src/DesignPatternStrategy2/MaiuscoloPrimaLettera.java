package DesignPatternStrategy2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaiuscoloPrimaLettera implements Formattazione {
	
	public String applica(String testo) {
		
        return Arrays.stream(testo.split(" "))//divide
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1)) //transoforma ogni parola.
                .collect(Collectors.joining(""));
    }
}
