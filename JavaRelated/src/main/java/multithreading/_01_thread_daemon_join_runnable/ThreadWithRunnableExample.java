package multithreading._01_thread_daemon_join_runnable;

public class ThreadWithRunnableExample {
  public static void main(String[] args) throws InterruptedException {

    /***
     * here we use neither join nor daemon, meaning it will run independently of main thread until it finishes
     */
    var myThread = new MyThread();
    myThread.start();

    var threadWithRunnable =
        new Thread(
            () -> {
              System.out.println("runnable thread called " + Thread.currentThread() + " starts");
              try {
                for (int i = 0; i < 5; i++) {
                  Thread.sleep(1000);
                  System.out.println(
                      "runnable thread called ("
                          + Thread.currentThread()
                          + ")  run for "
                          + (i + 1)
                          + " times");
                }
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("runnable thread called " + Thread.currentThread() + " stopped");
            });

    /***
     * why / when to use setDaemon?
     * we use it where we want the background thread to kill itself with the main thread
     * if main thread is no more alive, otherwise background thread may run forever although the
     * main thread gets killed
     */
    threadWithRunnable.setDaemon(true);
    threadWithRunnable.start();

    /***
     * why / when to use join?
     * we use join where we want main thread to wait for the background thread
     * even if the background thread has been set as daemon.
     * because "join" will pause the main thread until the background thread finishes the process of itself
     */
    threadWithRunnable.join();
    System.out.println(Thread.currentThread() + " main thread shuts down");
  }

  public static class MyThread extends Thread {
    @Override
    public void run() {
      System.out.println("my thread called " + Thread.currentThread() + " starts");
      try {
        for (int i = 0; i < 10; i++) {
          Thread.sleep(1000);
          System.out.println(
              "my thread (" + Thread.currentThread() + ") run for " + (i + 1) + " times");
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("my thread called " + Thread.currentThread() + " stopped");
      super.run();
    }
  }
}
