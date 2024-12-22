package concurrency.TransferFundsActor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
public class Account {
  private int accountId;
  private AtomicReference<BigDecimal> balance;

  public BigDecimal transferTo(final BigDecimal bigDecimal) {
    final var newBalance = balance.get().subtract(bigDecimal);

    balance.set(newBalance);

    return newBalance;
  }
}
