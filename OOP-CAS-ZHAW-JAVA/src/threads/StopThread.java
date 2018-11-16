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
		
	}

	public static void main(String[] args) {
		StopThread st = new StopThread();

	}

}
