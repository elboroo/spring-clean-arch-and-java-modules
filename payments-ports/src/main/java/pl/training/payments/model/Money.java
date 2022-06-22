package pl.training.payments.model;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal value, Currency currency) {
}
