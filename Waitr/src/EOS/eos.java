package EOS;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class eos {

	static String A [] = {"Birmingham,AL" , "Afmore,AL" , "Brewton,AL" , "Camden,AR" ,  "Jackson,AL" ,  "Eufaula, AL"};
	static String B [] = {"Montgomery, AL" , "Tuscaloosa, AL" , "Demopolis, AL" , "Indianola,MS" ,  "Clanton,AL" , "Kennett, MO"};	
	
	
	public static void main(String[] args){
		Arrays.sort(A);
		Arrays.sort(B);
		String relief = "@";
		String time = "Dispatching 9am - 3pm ";			
		printEOS(A,time,"4A",relief);
		
		printEOS(B,time,"4B",relief);
		
	}
	
	static void printEOS(String [] markets,String time, String block, String relief){
		
		System.out.println("\n"+"*".repeat(50)+" | "+block+" | "+"*".repeat(50));
		
		for(int i = 0; i<markets.length; i++){
			System.out.println();
			String output = marketEos(getDate(),time,markets[i],relief);
			System.out.println(output);
		}
	}
	
	static String marketEos(String date,String time,  String market, String relieftag){
		String title = "Dispatch EOS | " + date+" | "+time+ " | "+market ;
		String push = "Market Push \nNone\n";
		String surge = "Market Surge \nNone\n";
		String refunds= "Refunds and Voids \nNone\n";
		String output = title+"\n"+"-".repeat(title.length())+"\n"+push+surge+refunds+"Notes: \n\n"+"Relief: "+relieftag+"\n" + "=".repeat(title.length());
		
		return output;
		/*
		System.out.println(title);
		System.out.println("-".repeat(title.length()));
		System.out.println(push);
		System.out.println(surge);
		System.out.println(refunds);
		System.out.println("Note: ");
		System.out.println("Relief: "+relieftag);
		System.out.println();
		*/

	}
	
	static String getDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	   Date date = new Date();
		return formatter.format(date).toString();
		 
			
	}
	
}