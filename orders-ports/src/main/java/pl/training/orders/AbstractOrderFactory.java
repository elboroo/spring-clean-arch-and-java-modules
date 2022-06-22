package pl.training.orders;

import pl.training.orders.input.PlaceOrderUseCase;
import pl.training.orders.output.PaymentService;
import pl.training.orders.output.ProductsProvider;

public interface AbstractOrderFactory {

    PlaceOrderUseCase create(ProductsProvider productsProvider, PaymentService paymentService);

}
