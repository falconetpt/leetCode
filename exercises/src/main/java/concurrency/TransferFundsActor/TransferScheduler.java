package concurrency.TransferFundsActor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class TransferScheduler {
  private Map<Account, BlockingQueue<Transfer>> jobQueue;
  private Executor executor;

  public TransferScheduler() {
    jobQueue = new ConcurrentHashMap<>();
    executor = Executors.newCachedThreadPool();
    start();
  }

  public void schedule(Transfer transfer) {
    final var newTransfer = transfer.to().getAccountId() > transfer.from().getAccountId()
        ? new Transfer( transfer.to(), transfer.from(), transfer.toTransfer().negate())
        : transfer;
    jobQueue.putIfAbsent(newTransfer.from(), new LinkedBlockingDeque<>());
    jobQueue.get(newTransfer.from()).add(newTransfer);
  }

  public void start() {
    CompletableFuture.runAsync(() -> {
      while (true) executor.execute(this::run);
    });
  }

  private void run() {

    jobQueue.values().parallelStream().forEach(q -> {
      if (q != null && !q.isEmpty()) {
        final var element = q.poll();
        System.out.println(element);
        final var from = element.from().transferTo(element.toTransfer());
        final var to = element.to().transferTo(element.toTransfer().negate());

        if (from.compareTo(BigDecimal.ZERO) > 0 && to.compareTo(BigDecimal.ZERO) > 0) {
          //success
        } else {
          element.from().transferTo(element.toTransfer().negate());
          element.to().transferTo(element.toTransfer());
        }
      }
    });
  }
}
