package pl.training.payments.input;

import pl.training.payments.model.Payment;
import pl.training.payments.model.PaymentRequest;

public interface ProcessPaymentUseCase {

    Payment process(PaymentRequest paymentRequest);

}
