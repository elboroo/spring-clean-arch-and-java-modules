package pl.training.orders.domain;

import org.javamoney.moneta.FastMoney;

public record OrderEntryDomain(Long productId, FastMoney price, int quantity) {

    public FastMoney getTotalValue() {
        return price.multiply(quantity);
    }

}
