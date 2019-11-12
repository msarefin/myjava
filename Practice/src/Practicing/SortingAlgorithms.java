package Practicing;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {

	
	
	public static void main(String[] args) {
	
		List<String> continents = new ArrayList<>();
		
		continents.add("Asia");
		continents.add("Europe");
		continents.add("Africa");
		continents.add("North America");
		continents.add("South America");
		continents.add("Australia");
		continents.add("Antartica");
		
		String msg = "Continents";
		
		System.out.println(msg);
		
		System.out.println("=".repeat(msg.length()));
		
		for(String s: continents) {
			System.out.println(s);
		}
		
	}
	
}


