package com.voxelseries.currency.api.manager.entity;

import com.voxelseries.currency.api.PaymentQueue;
import lombok.Getter;
import net.endergrid.oxygen.api.entity.OxygenEntity;
import net.endergrid.oxygen.api.entity.annotation.field.EntityField;
import net.endergrid.oxygen.api.entity.annotation.session.Temporal;

import java.util.function.DoubleUnaryOperator;

public interface CurrencyValueEntity extends OxygenEntity {
    @Override
    default TemporalData getTemporalData() {
        return OxygenEntity.super.getTemporalData();
    }

    @EntityField("value")
    double get();

    @EntityField("value")
    double update(double value);

    @EntityField("value")
    double updateAndGet(DoubleUnaryOperator operator);

    @Temporal
    @Getter
    class TemporalData {
        private PaymentQueue queue;

        public TemporalData() {

        }
    }
}
