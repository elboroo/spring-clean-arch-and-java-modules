package pl.training.payments.domain;

import pl.training.payments.ports.model.Money;

interface FeeCalculator {

    Money calculate(Money paymentValue);

}
