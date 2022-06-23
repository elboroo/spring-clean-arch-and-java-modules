package pl.training.orders.ports;

import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.output.PaymentService;
import pl.training.orders.ports.output.ProductsProvider;

public interface AbstractOrderFactory {

    PlaceOrderUseCase create(ProductsProvider productsProvider, PaymentService paymentService);

}
