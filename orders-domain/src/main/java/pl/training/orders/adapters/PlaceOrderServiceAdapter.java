package pl.training.orders.adapters;

import lombok.RequiredArgsConstructor;
import pl.training.orders.domain.PlaceOrderService;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.model.Order;

@RequiredArgsConstructor
public class PlaceOrderServiceAdapter implements PlaceOrderUseCase {

    private final PlaceOrderService placeOrderService;
    private final OrderDomainMapper mapper;

    @Override
    public void place(Order order) {
        var orderDomain = mapper.toDomain(order);
        placeOrderService.place(orderDomain);
    }

}
