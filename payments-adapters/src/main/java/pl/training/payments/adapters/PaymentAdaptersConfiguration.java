package pl.training.payments.adapters;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("pl.training.payments.adapters.output.persistence.jpa")
@EnableJpaRepositories
@Configuration
public class PaymentAdaptersConfiguration {
}
