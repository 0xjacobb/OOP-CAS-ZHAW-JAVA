package threads;

public class  UnsyncCounter {
	public static void main(String[] args) {
		Counter counter = new Counter();
		for (int i = 0; i < 10; i++) {
			new Worker(counter).start();
		}
	}
}

class Counter {
	private int count = 0;
	public final static int LIMIT = 5;
	
	void up() {
		if (count < LIMIT) {
			count++;
		}
		if (count > LIMIT) {
			System.out.println("Counter overflow: " + count);
		}
	}
	
	void down() {
	    if (count > 0) {
	    	count --;
	    }
	    if (count < 0) {
			System.out.println("Counter ounderflow: " + count);
		}
	    
	}
}

class Worker extends Thread {
	Counter counter;
	
	Worker (Counter counter){
		this.counter = counter;
	}
	
	public void run() {
		System.out.print("Thread " + this.getName() + " started!");
		
		while(true) {
			for(int i = 0; i <= Counter.LIMIT; i++) {
				counter.up();
			}
			
			for(int i = 0; i < Counter.LIMIT; i++) {
				counter.down();
			}
		}
	}
}


