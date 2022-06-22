package pl.training.orders;

import org.javamoney.moneta.FastMoney;

import java.util.Set;

record OrderDomain(Long id, Set<OrderEntryDomain> entries) {

    private final static String DEFAULT_CURRENCY = "PLN";

    FastMoney getTotalValue() {
        return entries.stream()
                .map(OrderEntryDomain::getTotalValue)
                .reduce(FastMoney.of(0, DEFAULT_CURRENCY), FastMoney::add);
    }

}
