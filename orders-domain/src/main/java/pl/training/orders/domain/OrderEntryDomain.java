package pl.training.orders.domain;

import org.javamoney.moneta.FastMoney;

public record OrderEntryDomain(Long productId, FastMoney price, int quantity) {

    FastMoney getTotalValue() {
        return price.multiply(quantity);
    }

}
