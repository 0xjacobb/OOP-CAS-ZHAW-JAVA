package generics;

public class MainNode {

	public static void main(String[] args) {
		Node<String> next = new Node<String>("bar");
		Node<String> ns = new Node<String>("foo", next);
		System.out.println("String: " + ns.getInfo());
	}
}
