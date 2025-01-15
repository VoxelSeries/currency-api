package com.voxelseries.currency.api.manager.entity;

import net.endergrid.oxygen.api.entity.OxygenEntity;
import net.endergrid.oxygen.api.entity.annotation.field.EntityField;

import java.util.function.DoubleUnaryOperator;

public interface CurrencyValueEntity extends OxygenEntity {
    @EntityField("value")
    double get();

    @EntityField("value")
    double update(double value);

    @EntityField("value")
    double updateAndGet(DoubleUnaryOperator operator);
}
