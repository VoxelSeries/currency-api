package com.voxelseries.currency.api.kind;

import dev.oop778.keyedinstances.api.annotation.KeyedGroupId;
import dev.oop778.keyedinstances.api.instance.KeyedInstance;

import java.util.UUID;

@KeyedGroupId("currency")
public interface Currency extends KeyedInstance {
    int precision();

    String symbol();

    String nameSingular();

    String namePlural();

    double maxBalance();

    double getDefaultBalance(UUID uuid);
}
