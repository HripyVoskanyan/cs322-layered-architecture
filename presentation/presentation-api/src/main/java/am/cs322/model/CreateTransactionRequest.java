package am.cs322.model;

import jakarta.annotation.Nonnull;

public record CreateTransactionRequest(@Nonnull
                                       Long accountID,
                                       @Nonnull
                                       double amount) {
}
