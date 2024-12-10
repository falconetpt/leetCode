package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

public class FooSemaphore {
  private final Semaphore firstDone = new Semaphore(1);
  private final  Semaphore secondDone = new Semaphore(0);
  private final  Semaphore thirdDone = new Semaphore(0);

  public void first(Runnable runnable) throws InterruptedException {
    // printFirst.run() outputs "first". Do not change or remove this line.
    firstDone.acquire();
    runnable.run();
    secondDone.release();
  }

  public void second(Runnable runnable) throws InterruptedException {
    secondDone.acquire();
    // printSecond.run() outputs "second". Do not change or remove this line.
    runnable.run();
    thirdDone.release();
  }

  public void third(Runnable runnable) throws InterruptedException {
    thirdDone.acquire();
    // printThird.run() outputs "third". Do not change or remove this line.
    runnable.run();
    firstDone.release();
  }
}
