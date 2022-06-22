package pl.training.payments.output;

import pl.training.payments.model.Payment;

public interface PaymentWriter {

    Payment save(Payment payment);

}
