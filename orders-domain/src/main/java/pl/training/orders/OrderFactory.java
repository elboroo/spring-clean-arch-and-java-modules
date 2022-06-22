package pl.training.orders;

import org.mapstruct.factory.Mappers;
import pl.training.orders.input.PlaceOrderUseCase;
import pl.training.orders.output.PaymentService;
import pl.training.orders.output.ProductsProvider;

public class OrderFactory implements AbstractOrderFactory {

    private static final OrderDomainMapper MAPPER = Mappers.getMapper(OrderDomainMapper.class);

    @Override
    public PlaceOrderUseCase create(ProductsProvider productsProvider, PaymentService paymentService) {
        var placeOrderService = new PlaceOrderService(paymentService);
        MAPPER.setProductsProvider(productsProvider);
        return new PlaceOrderServiceAdapter(placeOrderService, MAPPER);
    }

}
