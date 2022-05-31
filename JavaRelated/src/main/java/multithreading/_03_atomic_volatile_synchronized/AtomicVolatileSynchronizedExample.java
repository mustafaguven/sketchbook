package multithreading._03_atomic_volatile_synchronized;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVolatileSynchronizedExample {

  // Use either synchronized keyword on line 61 (getCount method) or use atomic integer variable

  public static void main(String args[]) {
    final var counter = new IntegerCounter();
    var startingBarrier = new CyclicBarrier(5);
    var endingBarrier = new CyclicBarrier(7);

    Runnable task =
        () -> {
          try {
            startingBarrier.await();
            for (int i = 0; i < 1000; i++) {
              // counter.getCount();
              counter.incrementAndGet();
            }
            endingBarrier.await();

          } catch (InterruptedException | BrokenBarrierException ex) {
            ex.printStackTrace();
          }
        };

    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();

    new Thread(
            () -> {
              try {
                endingBarrier.await();
                System.out.println("another barrier which is passed");
              } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
              }
            })
        .start();

    try {
      endingBarrier.await();
      System.out.println("Expected count : 5001" + " Actual count : " + counter.getAtomicInteger());
    } catch (InterruptedException | BrokenBarrierException ex) {
      ex.printStackTrace();
    }
  }
}
/** A counter, which should return different count each time */
class IntegerCounter {
  private int count = 1;
  private final AtomicInteger atomicInteger = new AtomicInteger(1);

  public int getCount() {
    return count++;
  }

  public int getAtomicInteger() {
    return atomicInteger.get();
  }

  public int incrementAndGet() {
    return this.atomicInteger.incrementAndGet();
  }
}
