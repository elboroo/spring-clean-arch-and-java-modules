package pl.training.orders.output;

import pl.training.orders.model.Payment;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.Optional;

public interface PaymentService {

    Optional<Payment> pay(Long id, BigDecimal value, Currency currency, Map<String, String> properties);

}
