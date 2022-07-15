import java.util.concurrent.Callable;

public class GThread extends Thread {
  public static volatile int amount = 0;

  public static void main(String[] args) {
	GThread thread = new GThread();
    thread.start();
    while(thread.isAlive()) {
    	System.out.println("Waiting...");
	}
    System.out.println(amount);
    amount++;
    System.out.println(amount);
    // example Callable<Integer> i;
  }

  public void run() {
    amount++;
  }
}