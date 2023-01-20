package ds.mit.session.one.oracle;

public class YieldExample {

  public static void main(String[] args) {
    Thread producer = new Producer();
    Thread consumer = new Consumer();

    producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
    consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

    //for (int i = 0 ; i < 10 ; i++) {
    producer.start();
    consumer.start();
    //}

  }
}

class Producer extends Thread {

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println("Producer : Produced Item " + i);
      Thread.yield();
    }
  }
}

class Consumer extends Thread {

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println("Consumer : Consumed Item " + i);
      Thread.yield();
    }
  }
}
