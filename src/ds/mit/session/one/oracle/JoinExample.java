package ds.mit.session.one.oracle;

public class JoinExample {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(() -> {
      System.out.println("First task started");
      System.out.println("Sleeping for 3 seconds");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("First task completed");
    });
    Thread t1 = new Thread(() -> System.out.println("Second task completed"));
    t.start();
    t.join();
    t1.start();
  }
}