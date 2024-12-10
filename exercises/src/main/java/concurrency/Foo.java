package concurrency;

import java.util.concurrent.CompletableFuture;

public class Foo {
  private final CompletableFuture<Void> firstDone = new CompletableFuture<>();
  private final CompletableFuture<Void> secondDone = new CompletableFuture<>();

  public void first(Runnable runnable) {
    // printFirst.run() outputs "first". Do not change or remove this line.
    runnable.run();
    firstDone.complete(null);
  }

  public void second(Runnable runnable) throws InterruptedException {
    firstDone.join();
    // printSecond.run() outputs "second". Do not change or remove this line.
    runnable.run();
    secondDone.complete(null);
  }

  public void third(Runnable runnable) throws InterruptedException {
    secondDone.join();
    // printThird.run() outputs "third". Do not change or remove this line.
    runnable.run();
  }
}
