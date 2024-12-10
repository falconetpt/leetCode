package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
  private int n;
  private CompletableFuture completableFutureZero;
  private CompletableFuture completableFutureOdd;
  private CompletableFuture completableFutureEven;

  public ZeroEvenOdd(int n) {
    this.n = n;
    completableFutureZero = new CompletableFuture<>();
    completableFutureOdd = new CompletableFuture<>();
    completableFutureEven = new CompletableFuture<>();

    completableFutureZero.complete(null);
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i < n; i++) {
      completableFutureZero.join();
      completableFutureZero.thenRun(() -> printNumber.accept(0));

      if (i % 2 == 0) {
        completableFutureEven.complete(null);
      } else {
        completableFutureOdd.complete(null);
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i < n; i+=2) {
      int finalI = i;

      completableFutureEven.join();
      completableFutureEven.thenRun(() -> printNumber.accept(finalI));
      completableFutureZero.complete(null);

      completableFutureEven = new CompletableFuture();

    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i < n; i+=2) {
      int finalI = i;

      completableFutureOdd.join();
      completableFutureOdd.thenRun(() -> printNumber.accept(finalI));
      completableFutureZero.complete(null);

      completableFutureOdd = new CompletableFuture();

    }
  }
}
