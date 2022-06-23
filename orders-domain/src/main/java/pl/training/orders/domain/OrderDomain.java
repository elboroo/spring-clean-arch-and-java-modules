package pl.training.orders.domain;

import org.javamoney.moneta.FastMoney;

import java.util.Set;

public record OrderDomain(Long id, Set<OrderEntryDomain> entries) {

    private static final String DEFAULT_CURRENCY = "PLN";

    public FastMoney getTotalValue() {
        return entries.stream()
                .map(OrderEntryDomain::getTotalValue)
                .reduce(FastMoney.of(0, DEFAULT_CURRENCY), FastMoney::add);
    }

}
