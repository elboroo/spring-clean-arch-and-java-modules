package pl.training.shop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "pl.training")
@ComponentScan("pl.training")
@Configuration
public class ApplicationConfiguration {
}
