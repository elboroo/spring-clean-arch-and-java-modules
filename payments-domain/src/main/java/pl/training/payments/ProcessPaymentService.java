package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.training.payments.input.ProcessPaymentUseCase;
import pl.training.payments.model.Money;
import pl.training.payments.model.Payment;
import pl.training.payments.model.PaymentRequest;
import pl.training.payments.model.PaymentStatus;
import pl.training.payments.output.IdGenerator;
import pl.training.payments.output.PaymentWriter;
import pl.training.payments.output.TimeProvider;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ProcessPaymentService implements ProcessPaymentUseCase {

    private final IdGenerator idGenerator;
    private final TimeProvider timeProvider;
    private final FeeCalculator feeCalculator;
    private final PaymentWriter paymentWriter;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var totalValue = calculateTotalPaymentValue(paymentRequest);
        var payment = createPayment(totalValue);
        return paymentWriter.save(payment);
    }

    private Money calculateTotalPaymentValue(PaymentRequest paymentRequest) {
        var paymentValue = paymentRequest.value();
        var paymentFee = feeCalculator.calculate(paymentValue);
        return paymentValue.add(paymentFee);
    }

    private Payment createPayment(Money value) {
        return Payment.builder()
                .id(idGenerator.getNext())
                .timestamp(timeProvider.getTimestamp())
                .status(PaymentStatus.STARTED)
                .value(value)
                .build();
    }

}
