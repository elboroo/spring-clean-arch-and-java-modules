module pl.training.orders.prodcuts.adapters {
    exports pl.training.orders.adapters.output.prodcuts;

    requires pl.training.orders.ports;
    requires spring.context;
    requires static lombok;
}
