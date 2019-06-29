package practice;
import java.util.Scanner;

public class ScannarPractice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements ?");
		int size = sc.nextInt();
		System.out.println("enter i for Integer and s for string");
		String type = sc.next();
		if (type.contains("i")) {
			int arr[] = new int[size];
			int i = 0;
			while (i < size) {
				arr[i] = sc.nextInt();
				i++;
			}
			for (int n : arr) {
				System.out.println(n);
			}
		}
		if (type.contains("s")) {
			String arr[] = new String[size];
			int i = 0;
			while (i < size) {
				String n = sc.next();
				if (n.matches("[a-zA-Z]+")) {
					arr[i] = n;
					i++;
				}
			}
			for (String n : arr) {
				System.out.println(n);
			}
		}
	}
}
