package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.training.payments.input.GetPaymentUseCase;
import pl.training.payments.model.*;
import pl.training.payments.output.PaymentReader;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetPaymentService implements GetPaymentUseCase {

    private final PaymentReader paymentReader;

    @Override
    public Payment getById(String id) {
        return paymentReader.getById(id)
                .orElseThrow(PaymentNotException::new);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, PageRequest pageRequest) {
        return paymentReader.getByStatus(status, pageRequest);
    }

}
