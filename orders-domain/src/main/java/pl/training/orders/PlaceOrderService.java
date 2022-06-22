package pl.training.orders;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.training.orders.output.PaymentService;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static java.util.Collections.emptyMap;

@Log
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PlaceOrderService {

    private static final Currency CURRENCY = Currency.getInstance(Locale.getDefault());

    private final PaymentService paymentService;

    void place(OrderDomain orderDomain) {
        var paymentValue= BigDecimal.valueOf(orderDomain.getTotalValue().getNumber().doubleValueExact());
        var payment = paymentService.pay(1L, paymentValue, CURRENCY, emptyMap());
        log.info(orderDomain.toString());
        log.info(payment.toString());
    }

}
