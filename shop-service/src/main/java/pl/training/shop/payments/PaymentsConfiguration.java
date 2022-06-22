package pl.training.shop.payments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.payments.PaymentFactory;
import pl.training.payments.input.GetPaymentUseCase;
import pl.training.payments.input.ProcessPaymentUseCase;
import pl.training.payments.output.IdGenerator;
import pl.training.payments.output.PaymentReader;
import pl.training.payments.output.PaymentWriter;
import pl.training.payments.output.TimeProvider;

@Configuration
public class PaymentsConfiguration {

    private static final PaymentFactory PAYMENT_FACTORY = new PaymentFactory();

    @Bean
    public GetPaymentUseCase getPaymentUseCase(PaymentReader paymentReader) {
        return PAYMENT_FACTORY.create(paymentReader);
    }

    @Bean
    public ProcessPaymentUseCase processPaymentUseCase(IdGenerator idGenerator, TimeProvider timeProvider, PaymentWriter paymentWriter) {
        return PAYMENT_FACTORY.create(idGenerator, timeProvider, paymentWriter);
    }

}
