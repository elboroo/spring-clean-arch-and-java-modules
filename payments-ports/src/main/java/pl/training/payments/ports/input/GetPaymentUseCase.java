package pl.training.payments.ports.input;

import pl.training.payments.ports.model.PageRequest;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentStatus;
import pl.training.payments.ports.model.ResultPage;

public interface GetPaymentUseCase {

    Payment getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, PageRequest pageRequest);

}
