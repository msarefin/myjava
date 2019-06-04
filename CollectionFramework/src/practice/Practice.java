package practice;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {

//		Properties p = System.getProperties();
//		Set set = p.entrySet();
//
//		Iterator it = set.iterator();
//		while (it.hasNext()) {
//
//			Map.Entry entry = (Map.Entry) it.next();
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
		
		
		int maxSize = 100; 
		classDataArray arr; 
		arr = new classDataArray(maxSize); 
		
		
		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Lorriane", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Adams", "Henry", 63);
		arr.insert("Hashimoto", "Sato", 12);
		arr.insert("Stimson", "Henry", 29);
		arr.insert("Velasquez", "Jose", 72);
		arr.insert("Lamarque", "Henry", 54);
		arr.insert("vang", "Minh", 22);
		arr.insert("Careswell", "Lucinda", 18);
		
		arr.displayA();
		
		String searchKey = "Stimson"; 
		person found; 
		
		found = arr.find(searchKey);
		
	if(found !=null) {
		System.out.print("Found ");
		found.displayPerson();
	}
	else 
		System.out.println("Cant find "+ searchKey); 
	
	System.out.println("Deleting Smith, Yee  and Careswell");
	
	arr.delete("Smith");
	arr.delete("Yee");
	arr.delete("Careswell");
	
	
	arr.displayA();

	}
}

class person {
	private String lastname, firstname;
	private int age;

	public person(String lastname, String firstname, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public void displayPerson() {
		System.out.print(" last name: " + lastname);
		System.out.print(" , first name : " + firstname);
		System.out.println(", age " + age);

	}

	public String getlast() {
		return lastname;
	}

}

class classDataArray {
	private person[] a;
	private int nElems;

	public classDataArray(int max) {
		a = new person[max];
		nElems = 0;
	}

	public person find(String searchname) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j].getlast().equals(searchname))
				break;
		if (j == nElems)
			return null;
		else
			return a[j];

	}

	public void insert(String last, String first, int age) {
		a[nElems] = new person(last, first, age);
		nElems++;
	}

	public boolean delete(String searchName) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j].getlast().equals(searchName))
				break;
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++)
				a[k] = a[k + 1];
			nElems--;
			return true;
		}

	}

	public void displayA() {
		for (int i = 0; i < nElems; i++) {
			a[i].displayPerson();
		}
	}

}