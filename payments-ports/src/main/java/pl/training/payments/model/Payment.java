package pl.training.payments.model;

import lombok.Builder;

import java.time.Instant;

@Builder
public record Payment(String id, Money value, Instant timestamp, PaymentStatus status) {

    public boolean hasStatus(PaymentStatus status) {
        return this.status == status;
    }

}
