package pl.training.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.model.Order;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.model.Money;
import pl.training.payments.ports.model.PaymentRequest;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;

@Component
@Log
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private static final Currency CURRENCY = Currency.getInstance(Locale.getDefault());

    private final GetPaymentUseCase getPaymentUseCase;
    private final ProcessPaymentUseCase processPaymentUseCase;
    private final PlaceOrderUseCase placeOrderUseCase;

    @Override
    public void run(ApplicationArguments args) {
        var paymentRequest = new PaymentRequest(1L, new Money(BigDecimal.TEN, CURRENCY));
        var payment = processPaymentUseCase.process(paymentRequest);
        log.info("Payment: %s".formatted(getPaymentUseCase.getById(payment.id())));

        var order = new Order(1L, Map.of(1L, 4));
        placeOrderUseCase.place(order);
    }

}
