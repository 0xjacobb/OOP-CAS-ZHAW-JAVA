package generics;

public class Node<T> {
	private T info;
	private Node<T> next;
	
	public Node(T info) {
		this.info = info;
	}
	
	Node(T info, Node<T> next) {
		this.info = info;
		this.next = next; }
	
	public T getInfo() {
		return this.info;
	}
	
	public void setInfo(T info) { 
		this.info = info;
	}
	
	Node<T> getNext() { 
		return next;
	}
}
