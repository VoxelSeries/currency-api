package com.voxelseries.currency.api;

import com.voxelseries.currency.api.kind.CurrencySource;
import org.jetbrains.annotations.Nullable;

public interface PaymentQueue {
    void payUp();

    void add(Number amount);
    void add(Number amount, @Nullable CurrencySource source);

    PaymentQueue createSubQueue();
}
