package threads;

public class StopThread extends Thread {
	private boolean stopped = false;
	
	public StopThread() {
		start();
	}
	
	public synchronized void stopThread() {
		stopped = true;
	}
	
	public synchronized boolean isStopped() {
		return stopped;
	}
	
	public void run() {
		int count = 0;
		while(!isStopped()) {
			count ++;		
			System.out.println(count);
		}
		System.out.println("Thread ended jetzt");
	}

	public static void main(String[] args) {
		StopThread st = new StopThread();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		st.stopThread();
		System.out.println("Eine Meldung");

	}

}
