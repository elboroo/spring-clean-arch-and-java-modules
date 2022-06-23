package pl.training.shop.payments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.payments.ports.AbstractPaymentFactory;
import pl.training.payments.domain.PaymentFactory;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.output.IdGenerator;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import pl.training.payments.ports.output.TimeProvider;

@Configuration
public class PaymentsConfiguration {

    private static final AbstractPaymentFactory PAYMENT_FACTORY = new PaymentFactory();

    @Bean
    public GetPaymentUseCase getPaymentUseCase(PaymentReader paymentReader) {
        return PAYMENT_FACTORY.create(paymentReader);
    }

    @Bean
    public ProcessPaymentUseCase processPaymentUseCase(IdGenerator idGenerator, TimeProvider timeProvider, PaymentWriter paymentWriter) {
        return PAYMENT_FACTORY.create(idGenerator, timeProvider, paymentWriter);
    }

}
