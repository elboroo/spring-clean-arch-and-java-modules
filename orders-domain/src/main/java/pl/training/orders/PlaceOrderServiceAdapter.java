package pl.training.orders;

import lombok.RequiredArgsConstructor;
import pl.training.orders.input.PlaceOrderUseCase;
import pl.training.orders.model.Order;

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
