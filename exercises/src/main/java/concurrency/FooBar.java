package concurrency;

import java.util.concurrent.CompletableFuture;

class FooBar {
  private int n;
  private CompletableFuture fooCompletableFuture = new CompletableFuture();
  private CompletableFuture barCompletableFuture = new CompletableFuture();


  public FooBar(int n) {
    this.n = n;
    fooCompletableFuture.complete(null);
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      fooCompletableFuture.join();
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run();
      fooCompletableFuture = new CompletableFuture();
      barCompletableFuture.complete(null);
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      barCompletableFuture.join();
      // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run();
      barCompletableFuture = new CompletableFuture();
      fooCompletableFuture.complete(null);
    }
  }
}
