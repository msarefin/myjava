package EOS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class eos {

	public static void main(String[] args) {
		String[] A = { "Dummy market" };
		String[] B = {};
		String time = "7am - 2pm ";
		String relief = "@";

		printEos(A, time, "A", relief);
//		printEos(A, time, "B", relief);

	}

	static void printEos(String[] markets, String time, String block, String relief) {
		System.out.println("=".repeat(50) + " | " + block + " | " + "=".repeat(50));

		for (int i = 0; i < markets.length; i++) {
			System.out.println();
			marketEOS(getDate(), time, markets[i], relief);
		}
	}

	static void marketEOS(String date, String time, String market, String reliefTag) {
		String title = "Dispatch EOS | " + date + " | " + time + " | " + market;

		System.out.println(title);
		System.out.println("-".repeat(title.length()));
		System.out.println("Market Surge");
		System.out.println("Market Push");
		System.out.println("Refunds & Voids");
		System.out.println();
		System.out.println("note:");
		System.out.println("-".repeat(title.length()));
		System.out.println();
	}

	static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return formatter.format(date).toString();
	}
}
