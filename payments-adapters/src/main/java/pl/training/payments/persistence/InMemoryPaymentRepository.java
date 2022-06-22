package pl.training.payments.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.training.payments.model.PageRequest;
import pl.training.payments.model.Payment;
import pl.training.payments.model.PaymentStatus;
import pl.training.payments.model.ResultPage;
import pl.training.payments.output.PaymentReader;
import pl.training.payments.output.PaymentWriter;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryPaymentRepository implements PaymentReader, PaymentWriter {

    private final Map<String, Payment> payments;

    @Override
    public synchronized Optional<Payment> getById(String id) {
        return Optional.ofNullable(payments.get(id));
    }

    @Override
    public synchronized ResultPage<Payment> getByStatus(PaymentStatus status, PageRequest pageRequest) {
        var paymentsWithStatus = payments.values().stream()
                .filter(payment -> payment.hasStatus(status))
                .toList();
        return new ResultPage<>(paymentsWithStatus, pageRequest.pageNumber(), -1);
    }

    @Override
    public synchronized Payment save(Payment payment) {
        payments.put(payment.id(), payment);
        return payment;
    }

}
