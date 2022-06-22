package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.training.payments.model.Money;

import java.math.BigDecimal;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PercentageFeeCalculator implements FeeCalculator {

    private final BigDecimal percentage;

    @Override
    public Money calculate(Money paymentValue) {
        var fee = paymentValue.value().multiply(percentage);
        return new Money(fee, paymentValue.currency());
    }

}
