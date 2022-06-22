package pl.training.payments.output;

import pl.training.payments.model.PageRequest;
import pl.training.payments.model.Payment;
import pl.training.payments.model.PaymentStatus;
import pl.training.payments.model.ResultPage;

import java.util.Optional;

public interface PaymentReader {

    Optional<Payment> getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, PageRequest pageRequest);

}
