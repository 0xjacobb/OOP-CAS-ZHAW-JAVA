package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hashSetUebung {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Hallo");
		set.add("");
		set.add("Welt");
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
  }
}
