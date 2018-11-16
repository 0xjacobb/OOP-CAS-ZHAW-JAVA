package threads;

public class MeinRunnable implements Runnable {

	@Override
	public void run() {
		los();
	}
	
	private void los() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tuNochMehr();
	}
	
	private void tuNochMehr() {
		System.out.println("zben auf dem Stack");
	}

}
