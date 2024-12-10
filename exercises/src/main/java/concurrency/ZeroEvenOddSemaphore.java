package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOddSemaphore {
  private int n;
  private Semaphore zeroSph = new Semaphore(1);
  private Semaphore oddSph = new Semaphore(0);
  private Semaphore eveSph = new Semaphore(0);

  public ZeroEvenOddSemaphore(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      zeroSph.acquire();
      printNumber.accept(0);
      if (i % 2 == 0) {
        eveSph.release();
      } else {
        oddSph.release();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i+=2) {
      eveSph.acquire();
      printNumber.accept(i);
      zeroSph.release();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i+=2) {
      oddSph.acquire();
      printNumber.accept(i);
      zeroSph.release();
    }
  }
}
