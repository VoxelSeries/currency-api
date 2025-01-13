package com.voxelseries.currency.api.manager;

import com.voxelseries.currency.api.manager.entity.CurrencyEntity;

import java.util.UUID;

public interface CurrencyEntityManager {
    CurrencyEntity get(UUID uuid);
}
