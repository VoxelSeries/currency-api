package com.voxelseries.currency.api.manager.entity;

import com.voxelseries.currency.api.kind.CurrencyKind;
import net.endergrid.oxygen.api.collection.EntityMap;
import net.endergrid.oxygen.api.entity.OxygenEntity;
import net.endergrid.oxygen.api.entity.annotation.field.EntityField;

import javax.annotation.Nonnull;
import java.util.UUID;

public interface CurrencyEntity extends OxygenEntity {
    @EntityField("id")
    UUID id();

    @EntityField("currency")
    EntityMap<CurrencyKind, CurrencyValueEntity, CurrencyValueEntityTemplate> currency();

    default CurrencyValueEntity kind(@Nonnull CurrencyKind kind) {
        return this.currency().computeEntityIfAbsent(kind, () -> CurrencyValueEntityTemplate.builder()
                .withValue(kind.getDefaultBalance(this.id()))
                .build());
    }
}
