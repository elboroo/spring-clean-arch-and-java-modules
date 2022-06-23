package pl.training.payments.ports.model;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal value, Currency currency) {

    private static final String CURRENCY_SEPARATOR = " ";

    public static Money of(String text) {
        var elements = text.split(CURRENCY_SEPARATOR);
        var value = new BigDecimal(elements[0]);
        var currency = Currency.getInstance(elements[1]);
        return new Money(value, currency);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException();
        }
        return new Money(value.add(money.value), money.currency);
    }

    @Override
    public String toString() {
        return value + CURRENCY_SEPARATOR + currency;
    }
}
