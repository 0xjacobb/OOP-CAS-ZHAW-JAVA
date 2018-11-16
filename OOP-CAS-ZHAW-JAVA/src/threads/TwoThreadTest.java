package threads;

public class TwoThreadTest {
	
	public static void main (String[] args) {
		
		new SimpleThread("Jamaica").start(); 
		new SimpleThread("Fiji").start(); 
		System.out.println("main exits"+Thread.currentThread().toString());
  }
}
