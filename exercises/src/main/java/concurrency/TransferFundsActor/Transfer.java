package concurrency.TransferFundsActor;

import java.math.BigDecimal;

public record Transfer(Account from, Account to, BigDecimal toTransfer) { }
