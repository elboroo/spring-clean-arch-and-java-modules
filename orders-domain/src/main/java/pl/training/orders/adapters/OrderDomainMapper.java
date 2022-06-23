package pl.training.orders.adapters;

import lombok.Setter;
import org.javamoney.moneta.FastMoney;
import org.mapstruct.Mapper;
import pl.training.orders.domain.OrderDomain;
import pl.training.orders.domain.OrderEntryDomain;
import pl.training.orders.ports.model.Order;
import pl.training.orders.ports.output.ProductsProvider;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public abstract class OrderDomainMapper {

    @Setter
    private ProductsProvider productsProvider;

    public OrderDomain toDomain(Order order) {
        return new OrderDomain(order.id(), toDomain(order.entries()));
    }

    private Set<OrderEntryDomain> toDomain(Map<Long, Integer> entries) {
        return entries.entrySet().stream()
                .map(this::toDomain)
                .collect(Collectors.toSet());
    }

    private OrderEntryDomain toDomain(Map.Entry<Long, Integer> entry) {
        return new OrderEntryDomain(entry.getKey(), getProductPrice(entry.getKey()), entry.getValue());
    }

    private FastMoney getProductPrice(Long productId) {
        return FastMoney.parse(productsProvider.getById(productId)
                .orElseThrow(IllegalArgumentException::new)
                .price());
    }

}
