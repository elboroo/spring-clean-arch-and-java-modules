package pl.training.shop.orders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.orders.AbstractOrderFactory;
import pl.training.orders.OrderFactory;
import pl.training.orders.input.PlaceOrderUseCase;
import pl.training.orders.output.PaymentService;
import pl.training.orders.output.ProductsProvider;

@Configuration
public class OrdersConfiguration {

    private static final AbstractOrderFactory ORDER_FACTORY = new OrderFactory();

    @Bean
    public PlaceOrderUseCase placeOrderUseCase( ProductsProvider productsProvider, PaymentService paymentService) {
        return ORDER_FACTORY.create(productsProvider, paymentService);
    }

}
