
public class MainThreadLock {
	
	public static void main(String[] args) throws InterruptedException {
		
	System.out.println("Before DeadLock");
	Thread.currentThread().join();
	System.out.println("Will Never execute ");
	}

}
