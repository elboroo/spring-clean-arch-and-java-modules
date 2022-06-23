package pl.training.payments.ports.model;

public record PaymentRequest(Long id, Money value) {
}
