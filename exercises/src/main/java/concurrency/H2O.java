package concurrency;

import java.util.concurrent.Semaphore;

public class H2O {
  private Semaphore hSemaphore = new Semaphore(2);
  private Semaphore oSemaphore = new Semaphore(0);

  public H2O() {

  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    hSemaphore.acquire();
    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    releaseHydrogen.run();
    oSemaphore.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    oSemaphore.acquire(2);
    // releaseOxygen.run() outputs "O". Do not change or remove this line.
    releaseOxygen.run();
    hSemaphore.release(2);
  }
}
