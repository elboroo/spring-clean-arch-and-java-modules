package pl.training.payments.input;

import pl.training.payments.model.PageRequest;
import pl.training.payments.model.Payment;
import pl.training.payments.model.PaymentStatus;
import pl.training.payments.model.ResultPage;

public interface GetPaymentUseCase {

    Payment getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, PageRequest pageRequest);

}
