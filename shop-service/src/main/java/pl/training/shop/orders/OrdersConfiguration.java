package pl.training.shop.orders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.orders.ports.AbstractOrderFactory;
import pl.training.orders.adapters.OrderFactory;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.output.PaymentService;
import pl.training.orders.ports.output.ProductsProvider;

@Configuration
public class OrdersConfiguration {

    private static final AbstractOrderFactory ORDER_FACTORY = new OrderFactory();

    @Bean
    public PlaceOrderUseCase placeOrderUseCase( ProductsProvider productsProvider, PaymentService paymentService) {
        return ORDER_FACTORY.create(productsProvider, paymentService);
    }

}
