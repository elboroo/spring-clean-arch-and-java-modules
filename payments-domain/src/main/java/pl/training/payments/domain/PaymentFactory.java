package pl.training.payments.domain;

import pl.training.payments.ports.AbstractPaymentFactory;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.output.IdGenerator;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import pl.training.payments.ports.output.TimeProvider;

import java.math.BigDecimal;

public class PaymentFactory implements AbstractPaymentFactory {

    private static final FeeCalculator FEE_CALCULATOR = new PercentageFeeCalculator(BigDecimal.valueOf(0.01));

    @Override
    public GetPaymentUseCase create(PaymentReader paymentReader) {
        return new GetPaymentService(paymentReader);
    }

    @Override
    public ProcessPaymentUseCase create(IdGenerator idGenerator, TimeProvider timeProvider, PaymentWriter paymentWriter) {
        return new ProcessPaymentService(idGenerator, timeProvider, FEE_CALCULATOR, paymentWriter);
    }

}
