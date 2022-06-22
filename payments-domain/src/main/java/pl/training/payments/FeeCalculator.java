package pl.training.payments;

import pl.training.payments.model.Money;

interface FeeCalculator {

    Money calculate(Money paymentValue);

}
