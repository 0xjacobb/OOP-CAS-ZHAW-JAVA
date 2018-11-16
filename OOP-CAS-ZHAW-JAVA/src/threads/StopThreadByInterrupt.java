package threads;

public class StopThreadByInterrupt extends Thread {
	private boolean stopped = false;
	
	public StopThreadByInterrupt() {
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
		
		while(!isInterrupted()) {
			count ++;		
			System.out.println(count);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
		System.out.println("Thread ended jetzt");
	}

	public static void main(String[] args) {
		StopThreadByInterrupt st = new StopThreadByInterrupt();
		try {
			Thread.sleep(9100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		st.interrupt();
		System.out.println("main Thread fertig");

	}

}
