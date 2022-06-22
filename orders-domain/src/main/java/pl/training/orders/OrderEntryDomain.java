package pl.training.orders;

import org.javamoney.moneta.FastMoney;

record OrderEntryDomain(Long productId, FastMoney price, int quantity) {

    FastMoney getTotalValue() {
        return price.multiply(quantity);
    }

}
