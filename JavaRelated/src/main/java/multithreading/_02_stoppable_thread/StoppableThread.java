package multithreading._02_stoppable_thread;

public class StoppableThread implements Runnable {

  private boolean isStopped;

  @Override
  public void run() {
    while (!isStopped) {
      System.out.println(Thread.currentThread() + "running");
      sleep(1000);
    }
    System.out.println("stopped");
  }

  private void sleep(int i) {
    try {
      Thread.sleep(i);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public synchronized void setStopped(boolean stopped) {
    isStopped = stopped;
  }
}
