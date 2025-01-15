package com.voxelseries.currency.api.kind;

import com.voxelseries.currency.api.manager.entity.CurrencyEntity;
import com.voxelseries.currency.api.manager.entity.CurrencyValueEntity;
import com.voxelseries.currency.api.transaction.TransactionResult;
import dev.oop778.keyedinstances.api.annotation.KeyedGroupId;
import dev.oop778.keyedinstances.api.instance.KeyedInstance;

import java.util.UUID;

@KeyedGroupId("currency")
public interface CurrencyKind extends KeyedInstance {
    int precision();

    String symbol();

    String nameSingular();

    String namePlural();

    double maxBalance();

    double getDefaultBalance(UUID uuid);

    TransactionResult trySubtract(UUID uuid, double amount);

    double add(UUID uuid, double amount);

    boolean has(UUID uuid, double amount);

    CurrencyKindLanguage language();

    default double add(CurrencyEntity entity, double amount) {
        return entity.kind(this).updateAndGet((current) -> current + amount);
    }

    default boolean has(CurrencyEntity entity, double amount) {
        return entity.kind(this).get() >= amount;
    }

    default TransactionResult trySubtract(CurrencyEntity entity, double amount) {
        final boolean[] success = new boolean[1];

        final CurrencyValueEntity kindEntity = entity.kind(this);
        final double updatedBalance = kindEntity.updateAndGet((current) -> {
            if (current > amount) {
                success[0] = true;
                return current - amount;
            }

            return current;
        });

        return success[0]
                ? new TransactionResult.Success(kindEntity, updatedBalance)
                : new TransactionResult.Failed(TransactionResult.FailReason.NOT_ENOUGH_BALANCE);
    }
}
