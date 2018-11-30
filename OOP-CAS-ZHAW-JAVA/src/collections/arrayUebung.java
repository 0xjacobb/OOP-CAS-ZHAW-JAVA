package collections;

import java.lang.reflect.Array;
import java.util.Iterator;

public class arrayUebung {

	public static void main(String[] args) {
		String[] StringArray = {"Hallo","","Welt","","MARC"};
		
		for (int i = 0; i < StringArray.length; i++) {
			System.out.println(StringArray[i]);
		}
		
		for(String temp : StringArray) {
			System.out.println("For-Each: " + temp);			
		}
		
		Iterator<String> it = StringArray.iterator();
		while(it.hasNext()) {
			System.out.println("WHILE: " + it.next());
		}

	}
}
