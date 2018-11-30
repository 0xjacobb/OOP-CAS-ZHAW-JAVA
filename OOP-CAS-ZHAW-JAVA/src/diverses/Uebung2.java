package diverses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Uebung2 {

	public static void main(String[] args) {
		List<Person> persList = new ArrayList<Person>();
		
		persList.add(new Person("Hans", 84));
		persList.add(new Person("Anna", 15));
		persList.add(new Person("Marc", 35));
		persList.add(new Person("Angie", 36));
		
		Collections.sort(persList);
		
		for (Person  person: persList) {
			System.out.println(person.alter + " " +  person.name);
			
		}

	}

}
