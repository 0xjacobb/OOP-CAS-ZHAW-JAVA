package threads;

public class ThreadTestlauf {

	public static void main(String[] args) {
		Runnable threadJob = new MeinRunnable();
		Thread meinThread = new Thread(threadJob);
		meinThread.start();
		try {
			Thread.sleep(1);;
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("zurück zum main");
	}
}
