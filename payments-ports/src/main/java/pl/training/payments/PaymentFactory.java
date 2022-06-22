package pl.training.payments;

import pl.training.payments.input.GetPaymentUseCase;
import pl.training.payments.input.ProcessPaymentUseCase;
import pl.training.payments.output.IdGenerator;
import pl.training.payments.output.PaymentReader;
import pl.training.payments.output.PaymentWriter;
import pl.training.payments.output.TimeProvider;

public interface PaymentFactory {

    GetPaymentUseCase create(PaymentReader paymentReader);

    ProcessPaymentUseCase create(IdGenerator idGenerator, TimeProvider timeProvider, PaymentWriter paymentWriter);

}
