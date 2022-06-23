open module pl.trainig.shop.service {
    requires pl.training.payments.domain;
    requires pl.training.payments.adapters;
    requires transitive pl.training.payments.ports;

    requires pl.training.orders.domain;
    requires pl.training.orders.prodcuts.adapters;
    requires transitive pl.training.orders.ports;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires static lombok;
    requires java.logging;
}
