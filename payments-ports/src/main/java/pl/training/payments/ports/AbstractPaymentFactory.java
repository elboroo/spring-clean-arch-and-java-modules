package pl.training.payments.ports;

import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.output.IdGenerator;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import pl.training.payments.ports.output.TimeProvider;

public interface AbstractPaymentFactory {

    GetPaymentUseCase create(PaymentReader paymentReader);

    ProcessPaymentUseCase create(IdGenerator idGenerator, TimeProvider timeProvider, PaymentWriter paymentWriter);

}
