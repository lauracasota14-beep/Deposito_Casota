package eserciziCollection;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	public static void main(String[] args) {
		List<String> brani = new ArrayList<>(
				List.of("Intro", "Groove", "Ballad", "Finale"));
		
		brani.remove(2);
		brani.add(0,"sorpresa");
		
		System.out.println(brani);
		System.out.println("numero di branu " + brani.size());
	}

}
