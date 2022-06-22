package pl.training.payments.model;

import java.time.Instant;

public record Payment(String id, Money value, Instant timestamp, PaymentStatus status) {
}
