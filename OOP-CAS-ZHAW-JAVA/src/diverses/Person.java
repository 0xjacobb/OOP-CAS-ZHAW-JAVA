package diverses;

public class Person implements Comparable<Person>{
	
	public String name;
	public int alter;
	
	public Person (String name, int alter) {
		this.name = name;
		this.alter = alter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	@Override
	public int compareTo(Person o) {
		
		//return this.alter - o.alter;
		return this.name.compareTo(o.name);
	}

}
