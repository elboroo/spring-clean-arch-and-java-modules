package pl.training.payments;

import pl.training.payments.input.GetPaymentUseCase;
import pl.training.payments.input.ProcessPaymentUseCase;
import pl.training.payments.output.IdGenerator;
import pl.training.payments.output.PaymentReader;
import pl.training.payments.output.PaymentWriter;
import pl.training.payments.output.TimeProvider;

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
