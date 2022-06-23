package pl.training.payments.ports.model;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal value, Currency currency) {

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException();
        }
        return new Money(value.add(money.value), money.currency);
    }

}
