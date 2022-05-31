package multithreading._02_stoppable_thread;

public class StoppableThreadExample {
  public static void main(String[] args) throws InterruptedException {

    var runnable = new StoppableThread();

    var thread = new Thread(runnable);
    var thread2 = new Thread(runnable);
    thread2.start();
    thread.start();

    Thread.sleep(3000);


    runnable.setStopped(true);
  }
}
