package com.voxelseries.currency.api.transaction;

import com.voxelseries.currency.api.manager.entity.CurrencyValueEntity;
import lombok.NonNull;

public interface TransactionResult {
    enum FailReason {
        NOT_ENOUGH_BALANCE
    }

    record Success(CurrencyValueEntity entity, double updatedBalance) implements TransactionResult {}

    record Failed(@NonNull FailReason reason) implements TransactionResult {}
}
