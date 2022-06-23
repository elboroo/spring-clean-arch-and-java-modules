package pl.training.shop.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.training.orders.ports.model.Payment;
import pl.training.orders.ports.output.PaymentService;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.model.Money;
import pl.training.payments.ports.model.PaymentRequest;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceAdapter implements PaymentService {

    private final ProcessPaymentUseCase processPaymentUseCase;

    @Override
    public Optional<Payment> pay(Long id, BigDecimal value, Currency currency, Map<String, String> properties) {
        var paymentValue = new Money(value, currency);
        var paymentRequest = new PaymentRequest(id, paymentValue);
        var payment = processPaymentUseCase.process(paymentRequest);
        return Optional.of(new Payment(payment.id(), payment.status().name()));
    }

}
