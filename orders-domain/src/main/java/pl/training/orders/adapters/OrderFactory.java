package pl.training.orders.adapters;

import org.mapstruct.factory.Mappers;
import pl.training.orders.domain.PlaceOrderService;
import pl.training.orders.ports.AbstractOrderFactory;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.output.PaymentService;
import pl.training.orders.ports.output.ProductsProvider;

public class OrderFactory implements AbstractOrderFactory {

    private static final OrderDomainMapper MAPPER = Mappers.getMapper(OrderDomainMapper.class);

    @Override
    public PlaceOrderUseCase create(ProductsProvider productsProvider, PaymentService paymentService) {
        var placeOrderService = new PlaceOrderService(paymentService);
        MAPPER.setProductsProvider(productsProvider);
        return new PlaceOrderServiceAdapter(placeOrderService, MAPPER);
    }

}
