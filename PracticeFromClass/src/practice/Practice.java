package practice;

import java.time.temporal.WeekFields;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		System.out.println("Please a number for a day of the week: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dayOfTheWeek(n);
		
		System.out.println("*".repeat(10));
		
		System.out.println(WeekDay.dayOfTheWeek(n));
		
		property.levels();
		
		
		
	}

	static void dayOfTheWeek(int n) {
		String dayOfWeek = null; 
		switch (n) {
		case 1: {
			dayOfWeek="Sunday";
			break; 
		}
		case 2:{
			dayOfWeek="Monday";
			break; 
		}
		case 3:{
			dayOfWeek="Tuesday";
			break; 
		}
		case 4:{
			dayOfWeek="Wednesday";
			break; 
		}
		case 5:{ 
			dayOfWeek="Thursday";
			break; 
		}
		case 6: { 
			dayOfWeek="Friday";
			break; 
		}
		case 7:{ 
			dayOfWeek="Saturday";
			break; 
		}
		default:
			dayOfWeek="Invalid Day number entered !";
			break;  
		}
		
		System.out.println(dayOfWeek);
		
	}
	
	enum property{
		VERY_HIGH, HIGH, MEDIUM, LOW, BERY_LOW;
		
		private property() {
			System.out.println("constructor from property enum -->"+this.toString());
		}
		
		static void levels() {
			for(property p: property.values()) {
				System.out.println(p.toString());
			}
		}
	}
}

enum WeekDay {

	Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
	
	WeekDay(){
		System.out.println("Enums have constructors! -> "+this.toString());
	}
	
	static int num = 7; 

	 static String dayOfTheWeek(int n) {
		switch (n) {
		case 1: {
			return WeekDay.Sunday.toString();
		}
		case 2: {
			return WeekDay.Monday.toString();

		}
		case 3: {
			return WeekDay.Tuesday.toString();

		}
		case 4: {
			return WeekDay.Wednesday.toString();

		}
		case 5: {
			return WeekDay.Thursday.toString();

		}
		case 6: {
			return WeekDay.Friday.toString();
		}
		case 7: {
			return WeekDay.Saturday.toString();

		}
		default:
			return "You Enter an invalid number!\nPlease entere numbers between 1-7";

		}

	}

}